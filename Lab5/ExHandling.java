public class ExHandling {
	
	public static double[] toPercentages(double[] values) throws NullPointerException, IllegalArgumentException {
		int sum = 0;
		double[] result;
		result = new double[values.length];
		
		for (int i = 0; i < values.length; i++) { 
            if (values[i] < 0) {
            	throw new IllegalArgumentException("Element can not be " + i + " it must be under 0.");
            }
            sum +=  values[i];
		}
		
		if (sum == 0) {
			throw new IllegalArgumentException("Total can not be 0.");
		}
		
        for (int j = 0; j < values.length; j++) {
        	result[j] = values[j]/sum;
        }
        return result;
	}
}
