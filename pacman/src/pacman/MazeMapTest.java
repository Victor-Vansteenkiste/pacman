package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeMapTest {

	@Test
	void test() {
		MazeMap map = new MazeMap(4, 4, new boolean[] {true, false, true, true, true, false, true, false, false, false, true, false, false, true, true, false});
		assert map.getWidth() == 4;
		assert map.getHeight() == 4;
		assert map.isPassable(0, 0) == true;
	}

}
