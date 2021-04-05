package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 * 
 * @invar The square cannot be null.
 * 		| getSquare() != null
 * @invar The direction of the ghost cannot be null.
 * 		| getDirection() != null
 * 
 */
 
public class Ghost {
	
	/**
	 * @invar The square cannot be null. 
	 *		| square != null
	 * @invar The direction cannot be null
	 *		| direction != null 
	 *
	 */
	private Square square;
	private Direction direction;
	
	
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
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @throws IllegalArgumentException if the given direction is null.
	 * 		| direction == null
	 * @post The square equals the given square.
	 * 		|square == getSquare()
	 * @post The direction equals the given direction.
	 * 		|direction == getDirection()
	 *  
	 */
	public Ghost(Square square, Direction direction) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		if(direction == null)
			throw new IllegalArgumentException("direction is null");

		this.square = square;
		this.direction = direction;
	}
	 
	/** 
	 * Changes the value of square to the given square.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @post square equals the given square.
	 * 		| square == getSquare()
	 * @post direction remains unchanged.
	 * 		| old(getDirection()) == getDirection()
	 * 
	 */
	public void setSquare(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		
		this.square = square;
		}
	
	/**
	 * Changes the value of direction to the given direction.
	 * 
	 * @throws IllegalArgumentException if the given direction is null.
	 * 		| direction == null
	 * @post direction equals the given direction.
	 * 		| direction == getDirection()
	 * @post square remains unchanged.
	 * 		| old(getSquare()) == getSquare()
	 * 
	 */
	public void setDirection(Direction direction) { 
		if(direction == null)
			throw new IllegalArgumentException("direction is null");
		
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
	
	public boolean isVulnerable() {
		return true;
	}
}
