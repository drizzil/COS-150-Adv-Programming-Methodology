public class ParkedCar {
	private String make;
	private String model;
	private String color;
	private String licenseNumber;
	private int minutesParked;
	
	// constructors for ParkedCar
	public ParkedCar(String mk, String mod, String col, String lic, int min) {
		make = mk;
		model = mod;
		color = col;
		licenseNumber = lic;
		minutesParked = min;
	}
	public ParkedCar(ParkedCar car2) {
		make = car2.make;
		model = car2.model;
		color = car2.color;
		licenseNumber = car2.licenseNumber;
		minutesParked = car2.minutesParked;
	}
	
	// setters
	public void setMake(String ma) {
		make = ma;
	}
	public void setModel(String mod) {
		model = mod;
	}
	public void setColor(String c) {
		color = c;
	}
	public void setLicenseNumber(String l) {
		licenseNumber = l;
	}
	public void setMinutesParked(int mP) {
		minutesParked = mP;
	}
	
	
	// getters
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public int getMinutesParked() {
		return minutesParked;
	}
	
	// toString method overwrite
	public String toString() {
		return "Make: " + make + ", Model: " + model + ", Color: " + color + ", License Number: " + licenseNumber + ", Minutes Parked: " + minutesParked;
	}
}
