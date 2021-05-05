package pacman.wormholes;

public class Wormhole {
	private DeparturePortal departurePortal;
	private ArrivalPortal arrivalPortal;
	
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		this.arrivalPortal = arrivalPortal;
		this.departurePortal = departurePortal;
	}
	
	public void setDeparturePortal(DeparturePortal departurePortal) {
		this.departurePortal = departurePortal;
	}
	
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		this.arrivalPortal = arrivalPortal;
	}
	
	public DeparturePortal getDeparturePortal() {
		return departurePortal;
	}
	
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
	}
	
	
	
	

}
