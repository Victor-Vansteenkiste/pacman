package pacman;

public class PowerPellet extends FoodItem {
	private final Square square;
	
	public Square getSquare() {return square;}
	
	public PowerPellet(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
}
