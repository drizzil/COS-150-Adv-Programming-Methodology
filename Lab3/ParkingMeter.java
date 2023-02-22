public class ParkingMeter {
	// initialize private fields
	private int minutesPurchased;
	
	// Constructor
	public ParkingMeter(int m) {
		minutesPurchased = m;
	}
	// setter
	public void setMinutesPurchased(int m) {
		minutesPurchased = m;
	}
	// getter
	public int getMinutesPurchased() {
		return minutesPurchased;
	}
}	
