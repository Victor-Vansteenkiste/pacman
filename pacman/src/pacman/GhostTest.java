package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GhostTest {

	@Test
	void test() {
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, false, true, false, true, true, false});
		Square testSquare1 = Square.of(testMazeMap, 0, 0);
		Ghost testGhost = new Ghost(testSquare1, Direction.UP);
		assert testGhost.getSquare() == testSquare1;
		assert testGhost.getDirection() == Direction.UP;
		
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		testGhost.setSquare(testSquare2);
		testGhost.setDirection(Direction.DOWN);
		assert testGhost.getDirection() == Direction.DOWN;
		assert testGhost.getSquare() == testSquare2;
		
		
	}

}
