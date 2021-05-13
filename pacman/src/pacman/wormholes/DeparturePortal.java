package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;
import logicalcollections.LogicalSet;
 

/**
 * Each instance of this class represents a departure portal in a Pac-Man maze.
 * 
 * @invar The square cannot be null.
 * 		| getSquare() != null
 * @invar 
 * 		| getWormholes().stream().allMatch(wormhole -> wormhole != null && wormhole.getDeparturePortal() == this)
 */
public class DeparturePortal {
	
	/**
	 * @invar The square cannot be null. 
	 *		| square != null
	 * @invar 
	 *		| wormholes != null
	 * @invar 
	 *		| wormholes.stream().allMatch(wormhole -> wormhole != null)
	 *
	 * @representationobject
	 **/
	private Square square;
	/**
	 * @representationobject
	 */
	private Set<Wormhole> wormholes = new HashSet<>();
	
	/**
	 * Initializes the instance of this class with the given square.
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @post The square equals the given square.
	 * 		|square == getSquare()
	 */
	public DeparturePortal(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
	
	/** 
	 * Changes the value of square to the given square.
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null
	 * @mutates_properties | this.getSquare()
	 * @post square equals the given square.
	 * 		| square == getSquare()
	 */
	public void setSquare(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
	}
	
	/**
	 * Returns the square that the arrival portal is on.  		
	 * @basic 
	 */
	public Square getSquare() {
		return this.square;
	}
	
	/**
	 * @throws IllegalArgumentException if the given wormhole is null.
	 * 		| wormhole == null
	 * @mutates | this
	 * @post | getWormholesInternal().equals(LogicalSet.plus(old(getWormholesInternal()), wormhole))
	 * 
	 */
	void addWormhole(Wormhole wormhole) {
		if(wormhole == null)
			throw new IllegalArgumentException("The given wormhole is null");
		wormholes.add(wormhole);
	}
	
	/**
	 * @throws IllegalArgumentException if the given wormhole is null.
	 * 		| wormhole == null
	 * @mutates | this
	 * @post | getWormholesInternal().equals(LogicalSet.minus(old(getWormholesInternal()), wormhole))
	 * 
	 */
	void removeWormhole(Wormhole wormhole) {
		if(wormhole == null)
			throw new IllegalArgumentException("The given wormhole is null");
		wormholes.remove(wormhole);
	}
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @basic
	 */
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormholes);
	}
	
	/**
	 * @invar | getWormholesInternal().stream().allMatch(wormhole -> wormhole.getDeparturePortal() == this)
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(wormhole -> wormhole != null)
	 * @peerObjects // package level
	 * 
	 */
	Set<Wormhole> getWormholesInternal() {
		return Set.copyOf(wormholes);
	}
	
	
	
	
	
}
