public class Fraction {
	
	
	// setting private instances for the numerator and denominator of the fraction
	private int myNumerator;
	private int myDenominator;
	
	// a constructor that sets values for the instances, 0 and 1
	public Fraction() {
		myNumerator = 0;
		myDenominator = 1;
	}
	
	// a constructor that allows the programmer to set their own values for the fraction
	// if denominator is set as 0, an error will be printed and it will be set to 1
	// it utilizes the simplify method to find the simplified fraction
	public Fraction(int numerator, int denominator) {
		myNumerator = numerator;
		if (denominator == 0) {
			System.out.println("Error: Denominator can not be set as 0. Reset as 1.");
			myDenominator = 1;
		}
		else {
			myDenominator = denominator;
		}
		simplify();
	}
	
	// a method overwrite to choose how the fraction is displayed
	// it returns the fraction as a string
	public String toString() {
		return myNumerator + "/" + myDenominator;
	}
	
	// a getter to get the value for the numerator
	public int getNumerator() {
		return myNumerator;
	}
	// a getter to get the value for the denominator
	public int getDenominator() {
		return myDenominator;
	}
	
	// a method that takes the numerator and denominator and finds the greatest common denominator
	private static int computeGCD(int alpha, int beta) {
		alpha = Math.abs(alpha);
		beta = Math.abs(beta);
		int remainder = alpha % beta;
		while (remainder != 0) {
			alpha = beta;
		    beta = remainder;
		    remainder = alpha % beta;
		}
		return beta;
	}
	
	// a mutator that simplifies the numerator and denominator using the computeGCD method
	public void simplify() {
		int GCD = computeGCD(myNumerator, myDenominator);
		myNumerator = myNumerator/GCD;
		myDenominator = myDenominator/GCD;
	}
	
	// a method that multiplies two fractions together. It multiplies the numerators and denominators,
	// then it simplifies using the previous method and then it returns a string with the toString method
	public String multiply(Fraction f) {
		int newDenominator = f.getDenominator() * myDenominator;
		int newNumerator = f.getNumerator() * myNumerator;
		myNumerator = newNumerator;
		myDenominator = newDenominator;
		simplify();
		return 
			toString();			
	}
	
	
}
