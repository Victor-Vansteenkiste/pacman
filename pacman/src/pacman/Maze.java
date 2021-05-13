package pacman;

import java.util.Random;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	 
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private DeparturePortal[] departurePortals;
	private ArrivalPortal[] arrivalPortals;
	private Wormhole[] wormholes;
	
	public DeparturePortal[] getDeparturePortals() {
		return departurePortals.clone();
	}
	
	public ArrivalPortal[] getArrivalPortals() {
		return arrivalPortals.clone();
	}
	
	public Wormhole[] getWormholes() {
		return wormholes.clone();
	}
	 
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, DeparturePortal[] departurePortals, ArrivalPortal[] arrivalPortals ) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		this.arrivalPortals = arrivalPortals;
		this.departurePortals = departurePortals;
		
		this.wormholes = new Wormhole[0];
	}
	
	public void addWormhole(Wormhole wormhole) {
		Wormhole[] newWormholes = new Wormhole[wormholes.length + 1];
		for(int i = 0; i < wormholes.length; i++)
			newWormholes[i] = wormholes[i];
		newWormholes[wormholes.length] = wormhole;
		this.wormholes = newWormholes;
		
	}
	
	
	
	public boolean isCompleted() {
		return foodItems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random); 
		checkPacManDamage();
	}
	
	private void removeFoodItemAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void removeDotAtSquare(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				if(foodItems[i] instanceof PowerPellet) {
					for(int j = 0; j < ghosts.length;j++) {
						ghosts[j].pacManAtePowerPellet();
					}
				}
					
				removeFoodItemAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		DeparturePortal departurePortal = isCorrespondingDeparturePortal(newSquare);
		Wormhole[] posWormholes =  possibleWormholes(departurePortal);
		
		if(departurePortal != null && posWormholes.length != 0) {
			Random random = new Random();
			int randomInt = random.nextInt(posWormholes.length);
			Wormhole randomWormhole = posWormholes[randomInt];
			pacMan.setSquare(randomWormhole.getArrivalPortal().getSquare());
			checkPacManDamage();
			
			
		}else if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			removeDotAtSquare(newSquare);
			checkPacManDamage();
		}
	}
	
	private DeparturePortal isCorrespondingDeparturePortal(Square square) {
		for(DeparturePortal departurePortal : departurePortals) {
			if(departurePortal.getSquare().equals(square))
				return departurePortal;
		}
		return null;
	}
	
	private Wormhole[] possibleWormholes(DeparturePortal departurePortal) {
		Wormhole[] posWormholes = new Wormhole[0];
		Wormhole[] newPosWormholes;
		System.out.println(wormholes.length);
		for(Wormhole wormhole : wormholes) {
			if(wormhole.getDeparturePortal().equals(departurePortal)) {
				System.out.println("PACMAN");
				newPosWormholes = new Wormhole[posWormholes.length + 1];
				for(int i = 0; i < posWormholes.length; i++)
					newPosWormholes[i] = wormholes[i];
				newPosWormholes[posWormholes.length] = wormhole;
				posWormholes = newPosWormholes;
			
		}
			
		}
		
		return posWormholes;
	}
	
	
	
}
