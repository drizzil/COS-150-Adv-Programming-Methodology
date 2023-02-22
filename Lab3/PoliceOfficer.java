public class PoliceOfficer {
	// Private fields
	private String name;
	private String badgeNumber;
	
	// Constructors for PoliceOfficer
	public PoliceOfficer (String n, String bn) {
		name = n;
		badgeNumber = bn;
	}
	public PoliceOfficer (PoliceOfficer officer2) {
		name = officer2.name;
		badgeNumber = officer2.badgeNumber;
	}
	
	// setters
	public void setName(String n) {
		name = n;
	}
	public void setBadgeNumber(String b) {
		badgeNumber = b;
	}
	
	// getters
	public String getName() {
		return name;
	}
	public String getBadgeNumber() {
		return badgeNumber;
	}
	
	// method to test if the car should get a method. calls to ParkingTicket if it does and creates/returns the ticket
	public ParkingTicket patrol (ParkedCar car, ParkingMeter meter) {
		ParkingTicket ticket = null;
		
		int meterMinutes = meter.getMinutesPurchased();
		int carMinutes = car.getMinutesParked();
		if (carMinutes > meterMinutes) {
			int extraMinutes = carMinutes - meterMinutes;
			ParkingTicket ticket1 = new ParkingTicket(car, this, extraMinutes);
			return ticket1;
		}
		else {
			return ticket;
		}
		
	}
	
	// toString method overwrite
	public String toString() {
		return "Officer name: " + name + ", Badge number: " + badgeNumber;
	}
}
