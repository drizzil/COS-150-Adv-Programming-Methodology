
public class FractionDemo {

	public static void main(String[] args) {
		
		
		Fraction f1 = new Fraction();  // Construct default fraction obj
		System.out.println(f1);        // Print the object.

		Fraction f2 = new Fraction(3, 4);  // Construct a fraction object.
		System.out.println(f2);		   // Print the object.
		
		Fraction f3 = new Fraction(16, 4);     // Construct a fraction object
		System.out.println(f3);               // Print the object.

		
		System.out.println("The Numerator is " + f1.getNumerator());
		System.out.println("The Denominator is " + f1.getDenominator());
		
		System.out.println("f1 * f2 = " + f2.multiply(f3));  // Multiplies two fractions and prints
	}
}
