import java.lang.Math;

public class Cylinder extends Shape {

		private int radius;
		private int height;
		private static int count = 0;
		
		public Cylinder(String n, int r, int h) {
			super();
			radius = r;
			height = h;
			count++;
		}
		
		public String toString() {
			return "Cylinder";
		}
		
		public double getArea() {
			return 2*Math.PI*radius*height + 2*Math.PI*Math.pow(radius, 2);
		}
		
		public int getCount() {
			return count;
		}
}
