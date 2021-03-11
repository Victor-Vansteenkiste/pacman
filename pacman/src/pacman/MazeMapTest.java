package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
 
class MazeMapTest {
 
	@Test
	void test() {
		// Creating the instance testMap of the class MazeMap.
		MazeMap testMap = new MazeMap(4, 4, new boolean[] {true, false, true, true, true, false, true, false, false, false, true, false, false, true, true, false});
		
		// Testing the basic methods
		assert testMap.getWidth() == 4;
		assert testMap.getHeight() == 4;
		assert testMap.isPassable(0, 0) == true;
		assert testMap.isPassable(0, 1) == false;
		
		// Creating the instance testMap2 of the class MazeMap
		MazeMap testMap2 = new MazeMap(1, 1, new boolean[] {true});
		
		// Testing the basic methods
		assert testMap2.getHeight() == 1;
		assert testMap2.getWidth() == 1;
		assert testMap.isPassable(0, 0) == true;
	}

}
 