import java.util.Scanner;

public class PopulationPredict {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the starting number organisms: ");
		String orgS = in.nextLine();
		double org = Double.parseDouble(orgS);
		while (org < 2) {
			System.out.print("Please enter a number 2 or greater: ");
			orgS = in.nextLine();
			org = Double.parseDouble(orgS);
		}
		
		System.out.print("Enter the daily increase: ");
		String rateS = in.nextLine();
		double rate = Double.parseDouble(rateS);
		while (rate < 0) {
			System.out.println("Please enter a non-negative number: ");
			rateS = in.nextLine();
			rate = Double.parseDouble(rateS);
		}
		
		System.out.print("Enter the number of days the organisms will multiply: ");
		String timeS = in.nextLine();
		double time = Double.parseDouble(timeS);
		while (time < 1) {
			System.out.print("Please enter a a number 1 or greater: ");
			timeS = in.nextLine();
			time = Double.parseDouble(timeS);
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Day		Organisms");
		System.out.println("-------------------------");
		population(org, rate, time, 0);
		
		in.close();		
	}
	
	public static double population(double org, double rate, double time, int j) {
		j++;
		int i = 1;
		
		if (i == time) {
			System.out.print(j + "               ");
			System.out.println(org);
			return org;
		}
		else {
			System.out.print(j + "               ");
			System.out.println(org);
			return population(org + org * rate, rate, time - 1, j);
		}
	}
}
