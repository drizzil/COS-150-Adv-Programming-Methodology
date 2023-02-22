// Josh Newsome

import java.util.Arrays;

public class BigInteger {

	private String bigNum;
	
	// Constructor
	public BigInteger(String b) {
		bigNum = b;
	}

	// regular toString overwrite
	public String toString() {
		return bigNum;
	}
	
	// Method to turn the input string into an array.
	public int[] getNum() {
		String[] arr1 = bigNum.split("");
		int[] arr2 = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
		return arr2;
	}
	
	// Method to get the length of the arrays.
	public int getNumLen() {
		return bigNum.length();
	}
	
	// Uses the Java array equal method to check if the two numbers are equal.
	static boolean equals(BigInteger n1, BigInteger n2) {
		if (Arrays.equals(n1.getNum(), n2.getNum())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// method to check if one number is less than another. It checks each number to see if one is larger in the two arrays after checking
	// if the two arrays are the same length and not equal.
	static boolean less_than(BigInteger n1, BigInteger n2) {

		int arrW = 0;
		if (BigInteger.equals(n1, n2)) {
			return false;
		}
		if (n1.getNumLen() < n2.getNumLen()) {
			return true;
		}
		if (n2.getNumLen() < n1.getNumLen()) {
			return false;
		}
		
		for (int i = 0; i < n1.getNumLen(); i++) {
			int j = i;
			if (n1.getNum()[i] < n2.getNum()[i]) {
				arrW = 1;
				j = n1.getNumLen() + 1;
				return true;
			}
			if (n1.getNum()[i] > n2.getNum()[i]) {
				arrW = 0;
				j = n1.getNumLen() + 1;
			}
			else {
				continue;
			}
			i = j;
		}
		if (arrW == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Adds the two arrays as if on paper, uses a counter to carry a 1 if the sum of two numbers exceeds 9. Converts from array back to
	// string so the return will work.
	static BigInteger add(BigInteger n1, BigInteger n2) {
		// BigInteger a3 = new BigInteger("");
		int carry = 0;
	    int sum = 0;

	    int len1 = n1.getNumLen();
	    int len2 = n2.getNumLen();
	    int len = Math.max(len1, len2);

	    int arr3[] = new int[len + 1];

	    for (int i = 1; i <= len; i++) {
	        sum = (len1 - i >= 0 ? n1.getNum()[len1 - i] : 0) + (len2 - i >= 0 ? n2.getNum()[len2 - i] : 0) + carry;
	        arr3[len - i + 1] = sum % 10;
	        carry = sum / 10;
	    }
	    arr3[0] = carry;
	    String sA3 = (Arrays.toString(arr3).replaceAll("\\[|\\]|,|\\s", ""));
	    if (carry == 0) {
	    	sA3 = sA3.substring(1);
	    }
	    BigInteger a3 = new BigInteger(sA3);

	    return a3;
	}
	
	// Was going to use the add method to continuously add n1 by itself n2 amount of times. 
	static BigInteger multiply(BigInteger n1, BigInteger n2) {
		BigInteger n3 = new BigInteger("0");
		BigInteger counter = new BigInteger("0");
		
	/*
		for (int i = 0; i < counter; i++) {
			
		}
		*/
		
		return n3;
	}
}



/*
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-two-arrays/
 */
