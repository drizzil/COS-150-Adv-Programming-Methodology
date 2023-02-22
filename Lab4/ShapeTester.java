import java.util.Arrays;
import java.util.Scanner;

public class ShapeTester {
	
	public static int findIndex(double arr[], double t) 
    { 
  
        // if array is Null 
        if (arr == null) { 
            return -1; 
        } 
  
        // find length of array 
        int len = arr.length; 
        int i = 0; 
  
        // traverse in the array 
        while (i < len) { 
  
            // if the i-th element is t 
            // then return the index 
            if (arr[i] == t) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    } 

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of shapes you want to enter: ");
		String shapeNum = in.nextLine();
		int number = Integer.parseInt(shapeNum);
		Shape shapeArray[] = new Shape[number];
		
		double arr[];
		arr = new double[number];
		double arr2[];
		arr2 = new double[number];
		
		int arrCount[];
		arrCount = new int [number];
		
		for(int i = 1; i != number + 1; i++) {
			System.out.println("What type is shape " + i + "? ");
			String shapeType = in.nextLine();
			
			if (shapeType.equals("sphere")) {
				System.out.println("Enter the radius: ");
				String radNum = in.nextLine();
				int rad = Integer.parseInt(radNum);
				shapeArray[i - 1] = new Sphere("sphere", rad);
				arr[i - 1] = shapeArray[i - 1].getArea();
				arr2[i - 1] = shapeArray[i - 1].getArea();
				arrCount[i - 1] = shapeArray[i - 1].getCount();
			}
			
			if (shapeType.equals("cube")) {
				System.out.println("Enter the length: ");
				String lenNum = in.nextLine();
				int len = Integer.parseInt(lenNum);
				shapeArray[i - 1] = new Cube("cube", len);
				arr[i - 1] = shapeArray[i - 1].getArea();
				arr2[i - 1] = shapeArray[i - 1].getArea();
				arrCount[i - 1] = shapeArray[i - 1].getCount();
			}
			
			if (shapeType.equals("cylinder")) {
				System.out.println("Enter the radius: ");
				String radNum = in.nextLine();
				int rad = Integer.parseInt(radNum);
				System.out.println("Enter the  height: ");
				String heiNum = in.nextLine();
				int hei = Integer.parseInt(heiNum);
				shapeArray[i - 1] = new Cylinder("cylinder", rad, hei);
				arr[i - 1] = shapeArray[i - 1].getArea();
				arr2[i - 1] = shapeArray[i - 1].getArea();
				arrCount[i - 1] = shapeArray[i - 1].getCount();
			}
		}
		
		Arrays.sort(arr);

		System.out.println("Sorted Order");
		System.out.println("------------");
		
		for (int i = 0; i<=number - 1; i++) {
			int x = findIndex(arr2, arr[i]);
			// System.out.println(x);
			System.out.println(shapeArray[x].toString() + " " + arrCount[x] + ": " + arr[i] + " cm2");
		}
		
		in.close();
		
		
		
		

	}

}
