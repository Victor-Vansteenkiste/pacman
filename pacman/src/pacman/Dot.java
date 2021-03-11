package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * @invar Square is not null.
 * 		| getSquare() != null
 * @immutable
 */    
public class Dot {
	/**
	 * @invar Square is not null.
	 * 		| square != null
	 */
	private final Square square;
	
	/**
	 * Return the square of the object.
	 * @basic
	 * 
	 */
	public Square getSquare() { return square; }
	
	/**
	 * Constructor for the class dot.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 *  
	 * @post the square of the instance equals the given square.
	 * 		| getSquare() == square
	 */
	public Dot(Square square) { 
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}

}
