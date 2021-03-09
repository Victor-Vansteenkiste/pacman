package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * 
 * @invar The width is not negative.
 * 		| getWidth() >= 0
 * @invar The height is not negative.
 * 		| getHeight() >= 0		
 */
public class MazeMap {
	
	/**
	 * @invar The width is not negative.
	 * 		| width >= 0
	 * @invar The height is not negative.
	 * 		| height >= 0
	 * @invar The length of passable is the width multiplied by the height. 
	 * 		| passable.length == width * height
	 * @invar Passable is not null.
	 * 		| passable != null
	 * 
	 */
	private int width;
	private int height;
	/**
	 * An array of boolean values to represent the passable fields of the map (in row-major order)
	 * @representationobject
	 */
	private boolean[] passable;

	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @basic
	 */
	public int getWidth() { return width;}
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @basic
	 */
	public int getHeight() { return height; }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * 
	 * @throws IllegalArgumentException if the given row index is negative or greater than or equal to the height.
	 * 		| rowIndex < 0 || rowIndex >= getHeight()
	 * @throws IllegalArgumentException if the given column index is negative or greater than or equal to the width.
	 * 		| columnIndex < 0 || columnIndex >= getWidth()
	 * @basic
	 * @inspects | this
	 * 
	 */ 
	public boolean isPassable(int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= height)
			throw new IllegalArgumentException("Invalid row index");
		if(columnIndex < 0 || columnIndex >= width)
			throw new IllegalArgumentException("Invalid column index");
		 
		return passable[width * rowIndex + columnIndex];
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * 
	 * @throws IllegalArgumentException if width is negative.
	 * 		| width < 0
	 * @throws IllegalArgumentException if height is negative.
	 * 		| height < 0
	 * @throws IllegalArgumentException if passable is null.
	 * 		| passable == null
	 * @throws IllegalArgumentException if the length of passable doesn't equal the given width multiplied by the given height
	 * 		| passable.length != width * height
	 * 
	 * @post The width equals the given width.
	 * 		| width == getWidth()
	 * @post The height equals the given height.
	 * 		| height == getHeight()
	 * @post The passability equals the given passability.
	 * 		| IntStream.range(0, getHeight()).allMatch(rowIndex -> 
	 * 		|		IntStream.range(0, getWidth()).allMatch(columnIndex ->
	 * 		|			isPassable(rowIndex, columnIndex) == passable[getWidth() * rowIndex + columnIndex]))
	 * 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if(width < 0)
			throw new IllegalArgumentException("Negative width");
		if(height < 0)
			throw new IllegalArgumentException("Negative height");
		if(passable == null)
			throw new IllegalArgumentException("passable is null");
		if(passable.length != width * height)
			throw new IllegalArgumentException("Invalid length for passable");
 
		this.width = width;
		this.height = height;
		this.passable = passable.clone();
		
	}
}
