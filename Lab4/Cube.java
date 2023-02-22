import java.lang.Math;

public class Cube extends Shape {
	
	private int length;
	private static int count = 0;
	
	public Cube(String n, int l) {
		super();
		length = l;
		count++;
	}
	
	public String toString() {
		return "Cube";
	}
	
	public double getArea() {
		return 6*Math.pow(length, 2);
	}
	
	public int getCount() {
		return count;
	}
}
