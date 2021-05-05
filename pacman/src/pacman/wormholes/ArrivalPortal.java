package pacman.wormholes;

import pacman.Square;

public class ArrivalPortal {
	
	private Square square;
	
	public ArrivalPortal(Square square) {
		this.square = square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return this.square;
	}
	
	
}
