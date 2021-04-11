package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState {
	
	int moveDelay = 1;
	int counter = 0;
	@Override
	public GhostState move(Ghost ghost, Random random) {
		if(moveDelay == 0) {
			System.out.println("TEST");
			ghost.reallyMove(random);
			moveDelay = 1;
			counter++;
			
		}else {
			moveDelay = 0;
		}
		
		if(counter < 6)
			return new VulnerableGhostState(moveDelay, counter);
		else
			return new RegularGhostState();
			
	}
	
	public VulnerableGhostState(int moveDelay, int counter) {
		this.moveDelay = moveDelay;
		this.counter = counter;
	}
	
	@Override
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		ghost.setSquare(ghost.getOriginalSquare());
		return new RegularGhostState();
	}
	
	@Override
	public boolean isVulnerable() {
		return true;
	}
}
