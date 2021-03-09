package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacManTest {
 
	@Test
	void test() {
		MazeMap testMazeMap = new MazeMap(3, 3, new boolean[] {true, true, false, true, false, false, true, true, false});
		Square testSquare1 = Square.of(testMazeMap, 0, 0);
		PacMan testPacMan = new PacMan(3, testSquare1);
		assert testPacMan.getSquare() == testSquare1;
		assert testPacMan.getNbLives() == 3;
		Square testSquare2 = Square.of(testMazeMap, 0, 1);
		testPacMan.setSquare(testSquare2);
		assert testPacMan.getSquare() == testSquare2;
		assert testPacMan.getNbLives() == 3;
		testPacMan.die();
		assert testPacMan.getNbLives() == 2;
		assert testPacMan.getSquare() == testSquare2;
	}

}
