package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DotTest {

	@Test  
	void test() {
		// Creating instance testDot of the class Dot
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, true, false, false, false, true, true});
		Square testSquare = Square.of(testMazeMap, 0, 0);
		Dot testDot = new Dot(testSquare);
		
		// Testing the getter
		assert testDot.getSquare() == testSquare;
	}

}
