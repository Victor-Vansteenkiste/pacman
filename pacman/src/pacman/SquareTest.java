package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
  
class SquareTest {
  
	@Test
	void test() {
		MazeMap testMazeMap1 = new MazeMap(3, 3, new boolean[] {true, false, false, true, true, false, false, true, true});
		MazeMap testMazeMap2 = new MazeMap(1,1, new boolean[] {true});
		Square testSquare = Square.of(testMazeMap1, 0, 0);
		Square equalSquare = Square.of(testMazeMap1, 0, 0);
		Square differentRowSquare = Square.of(testMazeMap1, 1, 0);
		Square differentColumnSquare = Square.of(testMazeMap1, 0, 1);
		Square differentMapSquare = Square.of(testMazeMap2, 0, 0);
			
		assert testSquare.equals(equalSquare);
		assert testSquare.equals(differentRowSquare) == false;
		assert testSquare.equals(differentColumnSquare) == false;
		assert testSquare.equals(differentMapSquare) == false;
		
		
		assert testSquare.isPassable() == true;
		assert testSquare.canMove(Direction.RIGHT) == false;
		assert testSquare.getRowIndex() == 0;
		assert testSquare.getColumnIndex() == 0;
		
		Assert.assertArrayEquals(testSquare.getPassableDirectionsExcept(Direction.UP), new Direction[] {Direction.DOWN});
		Square testSquare2 = Square.of(testMazeMap1, 1, 1);
		Square testSquare3 = Square.of(testMazeMap1, 1, 2);
		Assert.assertArrayEquals(testSquare2.getPassableDirectionsExcept(Direction.UP), new Direction[] {Direction.DOWN, Direction.LEFT});
		Assert.assertArrayEquals(testSquare3.getPassableDirectionsExcept(Direction.UP), new Direction[] {Direction.RIGHT, Direction.DOWN, Direction.LEFT});
		Square testNeighborRight = testSquare3.getNeighbor(Direction.RIGHT);
		assert testNeighborRight.getRowIndex() == 1;
		assert testNeighborRight.getColumnIndex() == 0;
		assert testNeighborRight.isPassable() == true;
		Square testNeighborLeft = testSquare3.getNeighbor(Direction.LEFT);
		Square testNeighborUp = testSquare3.getNeighbor(Direction.UP);
		Square testNeighborDown = testSquare3.getNeighbor(Direction.DOWN);
		
		
		
	}

}
