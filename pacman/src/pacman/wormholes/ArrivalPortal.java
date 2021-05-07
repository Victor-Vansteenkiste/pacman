package pacman.wormholes;

import pacman.Square;

/**
 * Each instance of this class represents an arrival portal in a Pac-Man maze.
 * 
 * @invar The square cannot be null.
 * 		| getSquare() != null
 */
public class ArrivalPortal {
	
	/**
	 * @invar The square cannot be null. 
	 *		| square != null
	 **/
	private Square square;
	
	/**
	 * Initializes the instance of this class with the given square.
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @post The square equals the given square.
	 * 		|square == getSquare()
	 */
	public ArrivalPortal(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
	
	/** 
	 * Changes the value of square to the given square.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @mutates_properties | this.getSquare()
	 * @post square equals the given square.
	 * 		| square == getSquare()
	 */
	public void setSquare(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
	
	/**
	 * Returns the square that the arrival portal is on.  		
	 * @basic 
	 */
	public Square getSquare() {
		return this.square;
	}
	
	
}
