import java.lang.Math;

public class Sphere extends Shape {

	private int radius;
	private static int count = 0;
	
	public Sphere(String n, int r) {
		super();
		radius = r;
		count++;
	}
	
	public String toString() {
		return "Sphere";
	}
	
	public double getArea() {
		return 4*Math.PI*Math.pow(radius, 2);
	}
	
	public int getCount() {
		return count;
	}
	
}
