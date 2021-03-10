package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GhostTest {

	@Test
	void test() { 
		// Creating instance testGhost of the class Ghost
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, false, true, false, true, true, false});
		Square testSquare1 = Square.of(testMazeMap, 0, 0);
		Ghost testGhost = new Ghost(testSquare1, Direction.UP);
		
		// Testing the getters
		assert testGhost.getSquare() == testSquare1;
		assert testGhost.getDirection() == Direction.UP;
		
		// Creating new square of the same mazeMap
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		testGhost.setSquare(testSquare2);
		testGhost.setDirection(Direction.DOWN);
		
		// Testing the setters
		assert testGhost.getDirection() == Direction.DOWN;
		assert testGhost.getSquare() == testSquare2;
		
		
	}

}
