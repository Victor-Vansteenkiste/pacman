package pacman;

public abstract class FoodItem {

	public FoodItem() {}
	
	public abstract Square getSquare();
	
	public int getSize() {
		if(this instanceof Dot)
			return 1;
		else
			return 2;
	}
	
	
	
}
