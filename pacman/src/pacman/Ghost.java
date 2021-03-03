package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	
	// QUESTION --> hoe zit het met de precondities van deze klasses? Hoe moet je dat gaan noteren?
	private Square square;
	private Direction direction;
	
	// QUESTION --> moet je postcondities schrijven voor een basic getter?
	/**
	 * Returns the square that the ghost is on. 
	 * @basic 
	 */
	public Square getSquare() { return square; }
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 * @basic
	 */
	public Direction getDirection() { return direction; }
	
	/**
	 * Initializes the instance of this class with the given square and direction.
	 * 
	 * @post The square equals the given square.
	 * 		|square == getSquare()
	 * @post The direction equals the given direction.
	 * 		|direction == getDirection()
	 * 
	 */
	public Ghost(Square square, Direction direction) {
		
		this.square = square;
		this.direction = direction;
	}
	
	/**
	 * Changes the value of square to the given square.
	 * 
	 * @post square equals the given square.
	 * 		| square == getSquare()
	 * @post direction remains unchanged.
	 * 		| old(getDirection()) == getDirection()
	 * 
	 * 
	 * 
	 */
	public void setSquare(Square square) {
		this.square = square;
		}
	
	/**
	 * Changes the value of direction to the given direction.
	 * 
	 * @post direction equals the given direction.
	 * 		| direction == getDirection()
	 * @post square remains unchanged.
	 * 		| old(getSquare()) == getSquare()
	 * 
	 * 
	 */
	public void setDirection(Direction direction) { 
		this.direction = direction; 
		}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
