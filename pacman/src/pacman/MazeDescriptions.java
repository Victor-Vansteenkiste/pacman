package pacman;

import java.util.Arrays;
import java.util.Random;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;

public class MazeDescriptions {
	 
	private MazeDescriptions() { throw new AssertionError("This class is not intended to be instantiated"); }
	
	public static Maze createMazeFromDescription(Random random, String description) {
		String[] lines = description.trim().split("\n");
		
		int height = lines.length;
		int width = lines[0].length();
		
		boolean[] passable = new boolean[height * width];
		for (int i = 0; i < passable.length; i++)
			passable[i] = true;
		
		int nbFoodItems = 0;
		FoodItem[] foodItems = new FoodItem[width * height];
		
		int nbGhosts = 0;
		Ghost[] ghosts = new Ghost[width * height];
		
		DeparturePortal[] departurePortals = new DeparturePortal[0];
		ArrivalPortal[] arrivalPortals = new ArrivalPortal[0];
		
		
		for (int row = 0; row < lines.length; row++) {
			String line = lines[row];
			for (int column = 0; column < line.length(); column++) {
				char c = line.charAt(column);
				if (c == '#')
					passable[row * width + column] = false;
			}
		}
		MazeMap map = new MazeMap(width, height, passable);
		
		PacMan pacMan = null;
		for (int row = 0; row < lines.length; row++) {
			String line = lines[row];
			for (int column = 0; column < line.length(); column++) {
				char c = line.charAt(column);
				switch (c) {
				case ' ' -> {}
				case '#' -> {}
				case '.' -> foodItems[nbFoodItems++] = new Dot(Square.of(map, row, column));
				case 'G' -> ghosts[nbGhosts++] = new Ghost(Square.of(map, row, column), Direction.values()[random.nextInt(Direction.values().length)]);
				case 'P' -> {
					if (pacMan != null)
						throw new IllegalArgumentException("Maze description contains multiple P characters");
					pacMan = new PacMan(3, Square.of(map, row, column));
				}
				case 'p' -> foodItems[nbFoodItems++] = new PowerPellet(Square.of(map, row, column));
				case 'D' -> {
					DeparturePortal[] newDeparturePortals = new DeparturePortal[departurePortals.length + 1];
					for(int i = 0; i < departurePortals.length; i++)
						newDeparturePortals[i] = departurePortals[i];
					newDeparturePortals[departurePortals.length] = new DeparturePortal(Square.of(map, row, column));
					departurePortals = newDeparturePortals;
				}
				case 'A' -> {
					ArrivalPortal[] newArrivalPortals = new ArrivalPortal[arrivalPortals.length + 1];
					for(int i = 0; i < arrivalPortals.length; i++)
						newArrivalPortals[i] = arrivalPortals[i];
					newArrivalPortals[arrivalPortals.length] = new ArrivalPortal(Square.of(map, row, column));
					arrivalPortals = newArrivalPortals;
				}
				
				default -> throw new IllegalArgumentException("Invalid character in maze description: " + c);
				}
			}
		}
		
		if (pacMan == null)
			throw new IllegalArgumentException("Maze description does not contain a P character");
		
		return new Maze(random, map, pacMan, Arrays.copyOf(ghosts, nbGhosts), Arrays.copyOf(foodItems, nbFoodItems), departurePortals.clone(), arrivalPortals.clone());
	}

}
