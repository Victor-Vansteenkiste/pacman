package pacman.wormholes.Tests;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.*;

class DeparturePortalTest {

	@Test
	void test() { 
		// Creating instance testDeparturePortal of the class ArrivalPortal
		MazeMap testMazeMap = new MazeMap(3, 3,
				new boolean[] { true, true, false, false, true, false, true, true, false });
		Square testSquare1 = Square.of(testMazeMap, 0, 0);
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		Square testSquare3 = Square.of(testMazeMap, 2, 0);

		ArrivalPortal testArrivalPortal = new ArrivalPortal(testSquare2);
		DeparturePortal testDeparturePortal1 = new DeparturePortal(testSquare1);
		DeparturePortal testDeparturePortal2 = new DeparturePortal(testSquare3);
		Wormhole testWormhole1 = new Wormhole(testDeparturePortal1, testArrivalPortal);

		// Testing the getter
		assert testDeparturePortal1.getSquare() == testSquare1;

		// Creating new square of the same mazeMap
		Square testSquare4 = Square.of(testMazeMap, 1, 2);
		testDeparturePortal1.setSquare(testSquare4);

		// Testing the setters
		assert testDeparturePortal1.getSquare() == testSquare4;

		// Testing wormhole operators
		assert testDeparturePortal1.getWormholes().contains(testWormhole1);
		testWormhole1.setDeparturePortal(testDeparturePortal2);
		assert !testDeparturePortal1.getWormholes().contains(testWormhole1);
			
	}

}	

