public abstract class Shape {
	
	private String shapeName;
	
	public String toString() {
		return shapeName;
	}
	
	public abstract double getArea();
	public abstract int getCount();
	
}
