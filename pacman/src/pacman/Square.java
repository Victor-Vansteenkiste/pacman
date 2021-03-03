package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 */
public class Square {
	
	private MazeMap mazeMap;
	private int row;
	private int col;
    
	
	public MazeMap getMazeMap() { return this.mazeMap; }
	
	public int getRowIndex() { return this.row; }
	
	public int getColumnIndex() { return this.col; }
	
	public boolean isPassable() { return mazeMap.isPassable(row, col); }
	
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neighbor in the given direction, return the square that is farthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		int row = getRowIndex();
		int col = getColumnIndex();
		Square neighbor = new Square();
		
	    switch (direction) {
	        case RIGHT:
	            neighbor.row = (java.lang.Math.floorMod(row+1,22));
	            neighbor.col = col;
	            return neighbor;
	        case LEFT:
	        	neighbor.row = (java.lang.Math.floorMod(row-1,22));
	            neighbor.col = col;
	            return neighbor;
	        case UP:
	        	neighbor.row = row;
	            neighbor.col = (java.lang.Math.floorMod(row-1,28));
	            return neighbor;
	        case DOWN:
	        	neighbor.row = row;
	            neighbor.col = (java.lang.Math.floorMod(row+1,28));
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
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 */
	public boolean equals(Square other) {
		throw new RuntimeException("Not yet implemented");
	}
	
}


