package pacman;

public class PowerPellet extends FoodItem {
	private final Square square;
	private final int size = 2;
	
	public Square getSquare() {return square;}
	
	public PowerPellet(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
	
	/**
	 * @basic
	 * @post | result == 2 
	 * @post | getSquare() == old(getSquare())
	 */
	public int getSize() {
		return size;
	}
}
