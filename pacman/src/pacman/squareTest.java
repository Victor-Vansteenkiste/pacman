package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
 
class squareTest {

	@Test
	void test() {
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, false, false, true, true, false, false, true, true});
		Square testSquare = Square.of(testMazeMap, 0, 0);
		Square equalSquare = Square.of(testMazeMap, 0, 0);
		assert testSquare.equals(equalSquare) == true;
		assert testSquare.isPassable() == true;
		assert testSquare.canMove(Direction.RIGHT) == false;
		assert testSquare.getRowIndex() == 0;
		assert testSquare.getColumnIndex() == 0;
		Assert.assertArrayEquals(testSquare.getPassableDirectionsExcept(Direction.UP), new Direction[] {Direction.DOWN});
		
		
	}

}
