
package pacman;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PacManTest {
	@Test
	void test() {
		Square square1 = new Square();
		square.rowIndex = 5;
		square.columnIndex = 10;		
		
		PacMan pacman = new PacMan(1, square1);
		assert pacman.getNbLives() == 1;
		assert pacman.getSquare() == square1;
		
		Square square2 = new Square();
		square.rowIndex = 7;
		square.columnIndex = 2;
		pacman.setSquare(square2);
		assert pacman.getSquare() == square2;
		
		pacman.die();
		assert pacman.getNbLives() == 0;
		pacman.die();
		assert pacman.getNbLives() == 0;
		
		
		
	}
}
