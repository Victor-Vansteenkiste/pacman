package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 * @invar The row index is larger than 0 and smaller than the height of the map.
 * 		| getRowIndex() >= 0 && getRowIndex() < getMazeMap().getHeight()
 * @invar The column index is larger than 0 and smaller than the width of the map.
 * 		| getColumnIndex() >= 0 && getColumnIndex() < getMazeMap().getWidth()
 */

public class Square {
	
	/**
	 * 
	 */
	private MazeMap maze;
	private int row;
	private int column;
    
	/**
	 * Returns the maze map.
	 * @basic
	 */
	
	public MazeMap getMazeMap() { return this.maze; }
	
	/**
	 * Returns the row index of this square.
	 * @basic
	 */
	
	public int getRowIndex() { return this.row; }
	
	/**
	 * Returns the column index of this square.
	 * @basic
	 */
	
	public int getColumnIndex() { return this.column; }
	
	/**
	 * Returns whether the square in this maze is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * 
	 * @throws IllegalArgumentException if the given row index is negative or greater than or equal to the height.
	 * 		| rowIndex < 0 || rowIndex >= getHeight()
	 * @throws IllegalArgumentException if the given column index is negative or greater than or equal to the width.
	 * 		| columnIndex < 0 || columnIndex >= getWidth()
	 * @basic
	 * 
	 */
	
	public boolean isPassable() { 
		if (this.row < 0 || rowIndex >= this.maze.getHeight()) {
			throw new IllegalArgumentException("Invalid row index");
		}
		if (this.column < 0 || rowIndex >= this.maze.getWidth()) {
			throw new IllegalArgumentException("Invalid column index");
		}
		return mazeMap.isPassable(rowIndex, columnIndex); 
		}
	/**
	 * Initializes this object so that it represents a square with the given mazeMap, rowIndex, and
	 * columnIndex. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * 
	 * @throws IllegalArgumentException if width is negative.
	 * 		| rowIndex < 0 || rowIndex >= getHeight()
	 * @throws IllegalArgumentException if height is negative.
	 * 		| columnIndex < 0 || columnIndex >= getWidth()
	 * @throws IllegalArgumentException if the length of passable doesn't equal the given width multiplied by the given height
	 * 		| passable.length != width * height
	 * 
	 * @post The maze map equals the given maze map.
	 * 		| maze == getMazeMap()
	 * @post The row index equals the given row index.
	 * 		| row == getRowIndex()
	  * @post The column index equals the given column index.
	 * 		| column == getColumnIndex()
	 * 
	 * */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= mazeMap.getHeight()) {
			throw new IllegalArgumentException("Invalid row index");
		}
		if (this.columnIndex < 0 || rowIndex >= mazeMap.getWidth()) {
			throw new IllegalArgumentException("Invalid column index");
		}
		of.maze = mazeMap;
		of.row = rowIndex;
		of.column = columnIndex;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neighbor in the given direction, return the square that is farthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		private MazeMap maze = getMazeMap();
		private int rowindex = getRowIndex();
		private int columnindex = getColumnIndex();
		private int width = maze.getWidth();
		private int height = maze.getHeight();
		
		Square neighbor = new Square();
		
	    switch (direction) {
	        case RIGHT:
	            neighbor.rowIndex = (java.lang.Math.floorMod(rowIndex+1,width));
	            neighbor.columnIndex = columnIndex;
	            return neighbor;
	        case LEFT:
	        	neighbor.rowIndex = (java.lang.Math.floorMod(rowIndex-1,width));
	            neighbor.columnIndex = columnIndex;
	            return neighbor;
	        case UP:
	        	neighbor.rowIndex = rowIndex;
	            neighbor.columnIndex = (java.lang.Math.floorMod(rowIndex-1,height));
	            return neighbor;
	        case DOWN:
	        	neighbor.rowIndex = rowIndex;
	            neighbor.columnIndex = (java.lang.Math.floorMod(rowIndex+1,height));
	            return neighbor;
	    }
	    
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		Square to = getNeighbor(direction);
		return to.isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		private Direction[] passable_directions;
		for (Direction dir : Direction.values()){ 
			private Square neighbor = getNeighbor(dir);
			if (neighbor.isPassable()){
				passable_directions.add(direction);
			}
		}
		return passable_directions;
	}
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 */
	public boolean equals(Square other) {
		private int w1 = this.getRowIndex();
		private int w2 = other.getRowIndex();
		private int h1 = this.getColumnIndex();
		private int h2 = other.getColumnIndex();
		if ((w1 == w2) & (h1 == h2)) {
			return true;
		}
		return false;
	}
	
}


