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
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		Square testSquare3 = Square.of(testMazeMap, 2, 0);
		
		DeparturePortal testDeparturePortal = new DeparturePortal(testSquare2);
		ArrivalPortal testArrivalPortal1 = new ArrivalPortal(testSquare1);
		ArrivalPortal testArrivalPortal2 = new ArrivalPortal(testSquare3);
		Wormhole testWormhole1 = new Wormhole(testDeparturePortal, testArrivalPortal1);
		
		
		// Testing the getter
		assert testArrivalPortal1.getSquare() == testSquare1;
		
		// Creating new square of the same mazeMap
		Square testSquare4 = Square.of(testMazeMap, 1, 2);
		testArrivalPortal1.setSquare(testSquare4);

		
		// Testing the setters
		assert testArrivalPortal1.getSquare() == testSquare4;
			
		// Testing wormhole operators
		assert testArrivalPortal1.getWormholes().contains(testWormhole1);
		testWormhole1.setArrivalPortal(testArrivalPortal2);
		assert !testArrivalPortal1.getWormholes().contains(testWormhole1);
		
		
	}

}	





























