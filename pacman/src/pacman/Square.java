package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 *
 */
 
public class Square {
	
	/**
	 * @representationobject
	 */
	private MazeMap mazeMap ;
	private int rowIndex;
	private int columnIndex;
    
	/**
	 * Returns the maze map.
	 * 
	 * @throws 
	 * @basic
	 */
	
	public MazeMap getMazeMap() { return mazeMap; }
	
	/**
	 * Returns the row index of this square.
	 * @basic
	 */
	
	public int getRowIndex() { return rowIndex; }
	
	/**
	 * Returns the column index of this square.
	 * @basic
	 */
	
	public int getColumnIndex() { return columnIndex; }
	
	/**
	 * Returns whether the square in this maze is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * @basic
	 */
	public boolean isPassable() { 
		
		return mazeMap.isPassable(rowIndex, columnIndex);  
		}
	
	/**
	 * Initializes this object so that it represents a square with the given mazeMap, rowIndex, and
	 * columnIndex. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * 
	 * @throws IllegalArgumentException if row index is negative or greater than the height of the maze.
	 * 		| rowIndex < 0 || rowIndex >= mazeMap.getHeight()
	 * @throws IllegalArgumentException if column index is negative or greater than the width of the maze.
	 * 		| columnIndex < 0 || columnIndex >= mazeMap.getWidth()
	 * @throws IllegalArgumentException if the maze map equals null.
	 * 		| mazeMap == null
	 * 
	 * @post The row index of the result equals the given row index.
	 * 		| result.getRowIndex() == rowIndex
	 * @post The column index of the result equals the given column index.
	 * 		| result.getColumnIndex() == columnIndex
	 * @post The maze map of the result equals the given maze map.
	 * 		| result.getMazeMap() == mazeMap
	 * 
	 * */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (mazeMap == null)
			throw new IllegalArgumentException("mazeMap equals null");
		
		if (rowIndex < 0 || rowIndex >= mazeMap.getHeight()) 
			throw new IllegalArgumentException("Invalid row index");
		
		if (columnIndex < 0 || columnIndex >= mazeMap.getWidth()) 
			throw new IllegalArgumentException("Invalid column index");
		
	
		Square newSquare = new Square();
		newSquare.rowIndex = rowIndex;
		newSquare.columnIndex = columnIndex;
		newSquare.mazeMap = mazeMap;
		
		return newSquare;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neighbor in the given direction, return the square that is farthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		if(direction == null)
			throw new IllegalArgumentException("invalid direction");
		
		int width = mazeMap.getWidth();
		int height = mazeMap.getHeight();
		
		Square neighbor = new Square();
		neighbor.mazeMap = mazeMap;
	    switch (direction) {
	        case RIGHT:
	            neighbor.rowIndex = rowIndex;
	            neighbor.columnIndex = (java.lang.Math.floorMod(columnIndex+1,width));
	            return neighbor;
	        case LEFT:
	        	neighbor.rowIndex = rowIndex;
	            neighbor.columnIndex = (java.lang.Math.floorMod(columnIndex-1,width));
	            return neighbor;
	        case UP:
	        	neighbor.rowIndex = (java.lang.Math.floorMod(rowIndex-1,height));
	            neighbor.columnIndex = columnIndex;
	            return neighbor;
	        case DOWN:
	        	neighbor.rowIndex = (java.lang.Math.floorMod(rowIndex+1,height));
	            neighbor.columnIndex = columnIndex;
	            return neighbor;
	        default:
	        	throw new IllegalArgumentException("invalid direction"); 	
	    }
	    
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		if(direction == null) 
			throw new IllegalArgumentException("invalid direction");
		Square to = getNeighbor(direction);
		return to.isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		Direction[] passableDirections = new Direction[0];
		
		for (Direction direction : Direction.values()){ 
			if(direction == excludedDirection)
				continue;
			Square neighbor = getNeighbor(direction);
			if(neighbor.isPassable()) 
				passableDirections = updatePassableDirections(passableDirections, direction);
			
		}
		return passableDirections.clone();
	}
	
	/**
	 * Private method that adds a direction to the array of directions.
	 * 
	 */
	private Direction[] updatePassableDirections(Direction[] passableDirections, Direction newDirection) {
		Direction[] newPassableDirections = new Direction[passableDirections.length + 1];
		
		for(int i = 0; i < passableDirections.length; i++)
			newPassableDirections[i] = passableDirections[i];
		newPassableDirections[passableDirections.length] = newDirection;
		
		return newPassableDirections;
		
		
	}
				
			 
		
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 * 
	 * @throws IllegalArgumentException if other is null.
	 * 		| other == null
	 * @post the result is true if the maze maps are the same and if the row and column index are the same for the 2 squares.
	 * 		| result == ((getMazeMap() == other.getMazeMap()) && getRowIndex() == other.getRowIndex() && (getColumnIndex() == other.getColumnIndex()))
	 * @post the maze map of this object remains unchanged.
	 * 		| getMazeMap() == old(getMazeMap())
	 * @post the row index of this object remains unchanged.
	 * 		| getRowIndex() == old(getRowIndex())
	 * @post the column index of this object remains unchanged.
	 * 		| getColumnIndex() == old(getColumnIndex())	
	 * @inspects | this
	 * 
	 */
	public boolean equals(Square other) {
		if(other == null)
			throw new IllegalArgumentException("The given square is null");
		
		if(mazeMap != other.getMazeMap())
			return false;
		if(rowIndex != other.getRowIndex())
			return false;
		if(columnIndex != other.getColumnIndex())
			return false;
		return true;
	
	}
}


