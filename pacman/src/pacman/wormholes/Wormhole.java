package pacman.wormholes;
import logicalcollections.LogicalSet;

public class Wormhole {
	
	/**
	 * @representationobject
	 */
	private DeparturePortal departurePortal;
	/**
	 * @representationobject
	 */
	private ArrivalPortal arrivalPortal;
	

	/**
	 * @throws IllegalArgumentException if the given departure portal is null
	 * 		| departurePortal == null
	 * @throws IllegalArgumentException if the given arrival portal is null
	 * 		| arrivalPortal == null
	 * 
	 * @mutates_properties | arrivalPortal.getWormholes(), departurePortal.getWormholes()
	 * 
	 * @post | departurePortal == getDeparturePortal()
	 * @post | arrivalPortal == getArrivalPortal()
	 * @post | arrivalPortal.getWormholes().equals(LogicalSet.plus(old(arrivalPortal.getWormholes()), this))
	 * @post | departurePortal.getWormholes().equals(LogicalSet.plus(old(departurePortal.getWormholes()), this))
	 * 
	 */
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		if(departurePortal == null)
			throw new IllegalArgumentException("The given departure portal is null");
		if(arrivalPortal == null)
			throw new IllegalArgumentException("The given arrival portal is null");
		
		this.arrivalPortal = arrivalPortal;
		arrivalPortal.addWormhole(this);
		this.departurePortal = departurePortal;
		departurePortal.addWormhole(this);
		
	}
	
	/**
	 * @throws IllegalArgumentException if the given departure portal is null
	 * 		| departurePortal == null
	 * 
	 * @mutates_properties | departurePortal.getWormholes(), getArrivalPortal().getWormholes()
	 * 
	 * @post | departurePortal == old(getDeparturePortal())
	 * 		 |	?
	 * 		 | 	 departurePortal.getWormholes() == old(getDeparturePortal()).getWormholes() && 
	 * 		 |   	old(getArrivalPortal()).getWormholes() == getArrivalPortal().getWormholes() 
	 * 		 | : 
	 * 		 | 	 departurePortal.getWormholes().equals(LogicalSet.plus(old(departurePortal.getWormholes()), this)) &&
	 * 		 | 		getArrivalPortal().getWormholes().equals(LogicalSet.plus(old(getArrivalPortal().getWormholes()), this)) &&
	 * 		 | 	 		old(getDeparturePortal()).getWormholes().equals(LogicalSet.minus(old(old(getDeparturePortal().getWormholes())), this))
	 * 		
	 * 			
	 * @post | departurePortal == getDeparturePortal()
	 * 
	 */
	public void setDeparturePortal(DeparturePortal departurePortal) {
		if(departurePortal == null)
			throw new IllegalArgumentException("The given departure portal is null");
		this.departurePortal.removeWormhole(this);
		this.departurePortal = departurePortal;
		departurePortal.addWormhole(this);
		arrivalPortal.addWormhole(this);
		
	}
	
	
	/**
	 * @throws IllegalArgumentException if the given departure portal is null
	 * 		| arrivalPortal == null
	 * 
	 * @mutates_properties | arrivalPortal.getWormholes(), getDeparturePortal().getWormholes()
	 * 
	 * @post | arrivalPortal == old(getArrivalPortal())
	 * 		 |	?
	 * 		 | 	 arrivalPortal.getWormholes() == old(getArrivalPortal()).getWormholes() && 
	 * 		 |   	old(getDeparturePortal()).getWormholes() == getDeparturePortal().getWormholes() 
	 * 		 | : 
	 * 		 | 	 arrivalPortal.getWormholes().equals(LogicalSet.plus(old(arrivalPortal.getWormholes()), this)) &&
	 * 		 | 		getDeparturePortal().getWormholes().equals(LogicalSet.plus(old(getDeparturePortal().getWormholes()), this)) &&
	 * 		 | 	 		old(getArrivalPortal()).getWormholes().equals(LogicalSet.minus(old(old(getArrivalPortal().getWormholes())), this))
	 * 		
	 * 			
	 * @post | arrivalPortal == getArrivalPortal()
	 *  
	 */
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		if(departurePortal == null)
			throw new IllegalArgumentException("The given arrival portal is null");
		this.arrivalPortal.removeWormhole(this);
		this.arrivalPortal = arrivalPortal;
		arrivalPortal.addWormhole(this);
		departurePortal.addWormhole(this);
	}
	
	/**
	 * @basic
	 */
	public DeparturePortal getDeparturePortal() {
		return departurePortal;
	}
	
	/**
	 * @basic
	 */
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
	}
	
}
