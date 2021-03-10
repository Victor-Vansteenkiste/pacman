package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * 
 * @invar the number of lives cannot be a negative number.
 * 		| getNbLives() >= 0
 * @invar the square cannot be null.
 * 		| getSquare() != null
 * @mutable
 */
public class PacMan {
	 
	/**
	 * @invar the number of lives can't be negative.
	 * 		| nbLives >= 0
	 * @invar square cannot be null.
	 * 		| square != null
	 */
	private int nbLives;
	private Square square;
	
	/**
	 * Returns the square
	 * @basic
	 */ 
	public Square getSquare() { return square; }
	
	/**
	 * Returns the number of lives that the Pac-man still has.
	 * @basic
	 */
	public int getNbLives() { return nbLives; }

	/**
	 * Initializes the instance of this class with the given number of lives and the given square.
	 * 
	 * @throws IllegalArgumentException if the given number of lives is smaller than 0.
	 * 		| nbLives < 0
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 *  
	 * @post The number of lives of the object equals the given number of lives.
	 * 		| getNbLives() == nbLives
	 * @post The square of this object equals the given square.
	 * 		| getSquare() == square
	 */
	public PacMan(int nbLives, Square square) {
		this.nbLives = nbLives;
	    this.square = square;
	}
	 
	/**
	 * Sets the value of square with the given square.
	 * 
	 * @throws IllegalArgumentException if square is null.
	 * 		| square == null
	 * 
	 * @post square equals the given square.
	 * 		| getSquare() == square
	 * @post the number of lives has remained unchanged.
	 * 		| old(getNbLives()) == getNbLives()
	 */
	public void setSquare(Square square) { this.square = square; }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * 
	 * @throws IllegalStateException if nbLives is 0.
	 * 		| getNbLives() < 1
	 * @post the number of lives will be decreased by one.
	 * 		| getNbLives() == old(getNbLives()) - 1
	 * @post the square remains unchanged.
	 * 		| old(getSquare()) == getSquare()
	 * @mutates |this
	 */ 
	public void die() {
	   if (nbLives < 1) {
		   throw new IllegalStateException();
	   }
	   else {
		   nbLives -= 1;
	   }
	}
}
