public class ParkingTicket {
	// private fields
	private ParkedCar car;
	private PoliceOfficer officer;
	private double fine;
	private int minutes;
	
	// public fields for creating fine total
	public double BASE_FINE = 25.0;
	public double HOURLY_FINE = 10.0;
	
	// setters
	public void setFine(double f) {
		fine = f;
	}
	public void setMinutes(int m) {
		minutes = m;
	}
	
	// getters
	public double getFine() {
		return fine;
	}
	public int getMinutes() {
		return minutes;
	}
	
	
	// method to 
	public ParkingTicket(ParkedCar aCar, PoliceOfficer anOfficer, int min) {
		super();
		this.car = aCar;
		this.officer = anOfficer;
		this.minutes = min;
		
		// Calculates the fine total
		calculateFine();
	}
	
	// Fine calculator method
	public void calculateFine() {
		
		double hours = Math.ceil(minutes/60);
		
		fine = BASE_FINE;
		fine += (hours * HOURLY_FINE);
	}
	
	// toString method overwrite
	public String toString() {
		return "Car: [" + car + "]\nOfficer: [" + officer + "]\nFine: [$" + fine + "]";
	}
}
