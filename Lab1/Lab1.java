import java.util.Scanner;
import java.math.*;

// Josh Newsome

public class Lab1 {

	public static void main(String[] args) {

        double constant = 670616629.3844;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the origin star system: ");
        String originSystem = scan.nextLine();

        System.out.print("Enter the destination star system: ");
        String destinationSystem = scan.nextLine();

        System.out.print("Enter travel velocity as fraction of speed of light: ");
        double velocity = scan.nextDouble();

        System.out.print("Enter distance between the two systems in light years: ");
        double distance = scan.nextDouble();

        System.out.println("Traveling from " + originSystem + " to " + destinationSystem + ".");

        double timeDilation = ((1)/(Math.sqrt(1- Math.pow(velocity, 2))));
        System.out.println("Time dilation factor: " + timeDilation);

        double roundTrip = 2*(distance/velocity);
        System.out.println("Round trip travel time: " + roundTrip);

        double aged = roundTrip - roundTrip/timeDilation;
        System.out.println("When you return, you will have aged " + aged + " years less.");


        String aoriginCity = scan.nextLine();
        System.out.println();
        System.out.print("Enter the origin city: ");
        String originCity = scan.nextLine();

        System.out.print("Enter the destination city: ");
        String destinationCity = scan.nextLine();

        System.out.print("Enter travel velocity miles per hour: ");
        double velocityCity = scan.nextDouble();

        System.out.print("Enter distance between the two cities in miles: ");
        double distanceCity = scan.nextDouble();
        System.out.println("Traveling from " + originCity + " to " + destinationCity + ".");


        double timeDilationCity = ((1)/(Math.sqrt(1- Math.pow((velocityCity/constant), 2))));
        System.out.println("Time dilation factor: " + timeDilationCity);

        double roundTripCity = 2*(distanceCity/velocityCity);
        System.out.println("Round trip travel time: " + roundTripCity);

        double agedCity = 3600*(roundTripCity - (roundTripCity/timeDilationCity));
        System.out.println("When you return, you will have aged " + agedCity + " seconds less.");

        scan.close();
		}
	}
