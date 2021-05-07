package pacman.wormholes.Tests;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.*;

class ArrivalPortalTest {

	@Test
	void test() { 
		// Creating instance testArrivalPortal of the class ArrivalPortal
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, false, true, false, true, true, false});
		Square testSquare1 = Square.of(testMazeMap, 0, 0);
		ArrivalPortal testArrivalPortal = new ArrivalPortal(testSquare1);
		
		// Testing the getter
		assert testArrivalPortal.getSquare() == testSquare1;
		
		// Creating new square of the same mazeMap
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		testArrivalPortal.setSquare(testSquare2);

		
		// Testing the setters
		assert testArrivalPortal.getSquare() == testSquare2;
			
	}

}	





























