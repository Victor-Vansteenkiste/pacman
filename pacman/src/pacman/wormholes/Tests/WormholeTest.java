package pacman.wormholes.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;
 
class WormholeTest {
 
	@Test
	void test() {
		MazeMap mazeMap1 = new MazeMap(3, 3, new boolean[] {true, true, false, false, true, false, true, true, false});
		Square square1 = Square.of(mazeMap1, 0, 0);
		Square square2 = Square.of(mazeMap1, 0, 1);
		Square square3 = Square.of(mazeMap1, 2, 0);
		Square square4 = Square.of(mazeMap1, 1, 1);
		Square square5 = Square.of(mazeMap1, 2, 1);
		
		 
		DeparturePortal departurePortal1 = new DeparturePortal(square1);
		DeparturePortal departurePortal2 = new DeparturePortal(square2);
		ArrivalPortal arrivalPortal1 = new ArrivalPortal(square3);
		ArrivalPortal arrivalPortal2 = new ArrivalPortal(square5);
		
		
		Wormhole wormhole1 = new Wormhole(departurePortal1, arrivalPortal1);
		Wormhole wormhole2 = new Wormhole(departurePortal2, arrivalPortal1);
		
		
		assertEquals(departurePortal1, wormhole1.getDeparturePortal());
		assertEquals(arrivalPortal1, wormhole1.getArrivalPortal());
		assertEquals(Set.of(wormhole1), departurePortal1.getWormholes());
		assertEquals(Set.of(wormhole1, wormhole2), arrivalPortal1.getWormholes());
		
		assert arrivalPortal1.getWormholes().contains(wormhole2);
		assert arrivalPortal1.getWormholes().contains(wormhole1);
		assert departurePortal1.getWormholes().contains(wormhole1);
		assert departurePortal2.getWormholes().contains(wormhole2);

		DeparturePortal departurePortal3 = new DeparturePortal(square4);
		wormhole1.setDeparturePortal(departurePortal3);
		assert !departurePortal1.getWormholes().contains(wormhole1);
		assert departurePortal3.getWormholes().contains(wormhole1);
		assert arrivalPortal1.getWormholes().contains(wormhole1);
		
		wormhole2.setArrivalPortal(arrivalPortal2);
		assert !arrivalPortal1.getWormholes().contains(wormhole2);
		assert arrivalPortal2.getWormholes().contains(wormhole2);
		assert wormhole2.getArrivalPortal() == arrivalPortal2;
		assert departurePortal2.getWormholes().contains(wormhole2);

		

	}

}
