package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DotTest {

	@Test
	void test() {
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, true, false, false, false, true, true});
		Square testSquare = Square.of(testMazeMap, 0, 0);
		Dot testDot = new Dot(testSquare);
		assert testDot.getSquare() == testSquare;
	}

}
