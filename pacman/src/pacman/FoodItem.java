package pacman;

public abstract class FoodItem {
	
	private int size;
	public abstract Square getSquare();
	
	/**
	 * @basic
	 * @post | result == 1 || result == 2
	 * @post | getSquare() == old(getSquare())
	 */
	public abstract int getSize();

}
