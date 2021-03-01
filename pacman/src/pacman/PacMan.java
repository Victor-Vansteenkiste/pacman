package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 */
public class PacMan {
	
	public int lives;
	public Square square;
	
	public Square getSquare() { return this.square; }
	
	public int getNbLives() { return this.lives; }

	public PacMan(int nbLives, Square square) {
		this.lives = nbLives;
	    this.square = square;
	}
	
	public void setSquare(Square square) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 */
	public void die() {
	   if (this.lives < 1) {
		   throw new IllegalStateException();
	   }
	   else {
		   this.lives -= 1;
	   }
	}
}
