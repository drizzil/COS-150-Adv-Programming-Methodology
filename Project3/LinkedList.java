import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LinkedList {
	
	public class Node {
        private int num1;	// data stored in linked list
        private int num2;
        private Node next;	// self-referencing pointer
        
        Node (int number1, int number2, Node nextNode) {	// Constructor
            num1 = number1;
            num2 = number2;
            next = nextNode;
        }
    }
	
	private Node head; // pointer to the first node in the linked list.
	private Node sorted; // sorted node.
	
	public LinkedList() {	// Constructor for linked list
		head = null;
	}
	
	public void addToFront(int n1, int n2) {	// Add new node to front of list.
		head = new Node(n1, n2, head);
	}
	
	public void addToEnd(int n1, int n2) {	// Add new node to end of list.
		if (head == null) {
			addToFront(n1, n2);
		}
		else {
			Node current = null;
			// could use while loop, but not going to
			for (current = head; current.next != null; current = current.next) {
				// do nothing; just get me to the end
			}
			current.next = new Node(n1, n2, null);
		}
	}
	
	public void printList() { // Prints list as polynomial
		if (head == null) {
			System.out.println("The list is empty.");
		}
		else {
			Node current = head;
			while (current != null) {
				if (current.num2 == 0) {
					System.out.print(current.num1);
				}
				else if (current.num1 == 1 || current.num1 == -1) {
					if (current.num2 == 1 || current.num2 == -1) {
						System.out.print("x");
					}
					else {
						System.out.print("x^" + current.num2);
					}
				}
				else if (current.num2 == 1) {
					System.out.print(current.num1 + "x");
				}
				else if (current.num1 == 0) {
					
				}
				else {
					if (current.num1 < 0) {
						System.out.print(current.num1/-1 + "x^" + current.num2);
					}
					else {
						System.out.print(current.num1 + "x^" + current.num2);
					}
				}
				
				if (current.next != null && current.next.num1 != 0) {
					if (current.next.num2 == 0) {
						if (current.next.num1 > 0) {
							System.out.print(" + ");
						}
						else {
							System.out.print(" - ");
						}
					}
					else {
						if (current.next.num1 > 0) {
							System.out.print(" + ");
						}
						else {
							System.out.print(" - ");
						}
					}
				}
				current = current.next;	
			}
			System.out.println();
		}
	}
	
	public void insertionSort(Node headref) { // Sorts list
        // Initialize sorted linked list
        sorted = null;
        Node current = headref;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) 
        {
            // Store next for next iteration
            Node next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
    }
	
	public void sortedInsert(Node newnode) { // Sorts list
        /* Special case for the head end */
        if (sorted == null || sorted.num2 <= newnode.num2) 
        {
            newnode.next = sorted;
            sorted = newnode;
        }
        else 
        {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.num2 > newnode.num2) 
            {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }
	
	public static void derivePoly(Node n1, Node n2) { // Derives 2 polynomials.
		Node current1 = n1;
		Node current2 = n2;
		LinkedList ll3 = new LinkedList();
		LinkedList ll4 = new LinkedList();
		while (current1 != null) {
			ll3.addToFront(n1.num1 * n1.num2, n1.num2 - 1);
			current1 = current1.next;
			n1 = n1.next;
		}
		while (current2 != null) {
			ll4.addToFront(n2.num1 * n2.num2, n2.num2 - 1);
			current2 = current2.next;
			n2 = n2.next;
		}
		ll3.insertionSort(ll3.head);
		ll4.insertionSort(ll4.head);
		System.out.print("p1 der = ");
		ll3.printList();
		System.out.print("p2 der = ");
		ll4.printList();
	}
	
	public static void multiPoly(Node n1, Node n2) { // Multiplies 2 polynomials.
		Node current1 = n1;
		Node current2 = n2;
		LinkedList ll3 = new LinkedList();
		
		while (current1 != null) {
			while (current2 != null) {
				ll3.addToFront(current1.num1 * current2.num1, current1.num2 + current2.num2);
				current2 = current2.next;
			}
			current2 = n2;
			current1 = current1.next;
		}
		ll3.insertionSort(ll3.head);
		System.out.print("Prod = ");
		combineList(ll3.head);
	}
	
	public static void combineList(Node n1) { // Adds the coefficients that have the same power in a single polynomial.
		Node current1 = n1;
		Node current2 = n1;
		Node c3 = n1;
		LinkedList ll3 = new LinkedList();
		LinkedList ll4 = new LinkedList();
		while (current2 != null) {
			ll3.head = null;
			while (current1 != null) {
				if (current1.next == null) {
					ll3.addToFront(current1.num1, current1.num2);
					break;
				}
				else if (current1.num2 == current1.next.num2) {
					ll3.addToFront(current1.num1 + current1.next.num1, current1.num2);
					
					
					current1 = current1.next;
				}
				else {
					ll3.addToFront(current1.num1, current1.num2);
					
				}
				current1 = current1.next;
			}
			c3 = ll3.head;
			current1 = c3;
			
			current2 = current2.next;
		}
		ll3.insertionSort(ll3.head);
		ll3.printList();
	}
	
	public static void subList(Node n1) { // Subtracts the coefficients that have the same power in a single polynomial.
		Node current1 = n1;
		Node current2 = n1;
		Node c3 = n1;
		LinkedList ll3 = new LinkedList();
		LinkedList ll4 = new LinkedList();
		while (current2 != null) {
			ll3.head = null;
			while (current1 != null) {
				if (current1.next == null) {
					ll3.addToFront(current1.num1, current1.num2);
					break;
				}
				else if (current1.num2 == current1.next.num2) {
					ll3.addToFront(current1.num1 - current1.next.num1, current1.num2);
					
					
					current1 = current1.next;
				}
				else {
					ll3.addToFront(current1.num1, current1.num2);
					
				}
				current1 = current1.next;
			}
			c3 = ll3.head;
			current1 = c3;
			
			current2 = current2.next;
		}
		ll3.insertionSort(ll3.head);
		ll3.printList();
	}
	
	public static void newSum(Node n1, Node n2) { // Combines the two linked lists and then adds with combineList.
		Node current1 = n1;
		Node current2 = n2;
		LinkedList ll3 = new LinkedList();
		
		while (current1 != null) {
			ll3.addToFront(current1.num1, current1.num2);
			current1 = current1.next;
		}
		while (current2 != null) {
			ll3.addToFront(current2.num1, current2.num2);
			current2 = current2.next;
		}
		ll3.insertionSort(ll3.head);
		System.out.print("sum = ");
		combineList(ll3.head);
	}
	
	public static void newSub(Node n1, Node n2) { // Combines the two linked lists and then subtracts with subList.
		Node current1 = n1;
		Node current2 = n2;
		LinkedList ll3 = new LinkedList();
		
		while (current1 != null) {
			ll3.addToFront(current1.num1, current1.num2);
			current1 = current1.next;
		}
		while (current2 != null) {
			ll3.addToFront(current2.num1, current2.num2);
			current2 = current2.next;
		}
		ll3.insertionSort(ll3.head);
		System.out.print("sub = ");
		subList(ll3.head);
	}
	
	public static void main(String[] args) throws IOException {
		
		try {
		File file = new File(args[0]);    //creates a new file instance  
		FileReader fr = new FileReader(file);   //reads the file  
		BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
		// StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters  
		String line;
        String[] poly = {"", ""};
        int i = 0;
		while ((line = br.readLine()) != null) {  
            poly[i] = line; 
            i++;
		} 
        // System.out.println(poly[0]);
        // System.out.println(poly[1]);
        br.close();
        int[] intArray1 = Arrays.stream(poly[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] intArray2 = Arrays.stream(poly[1].split(" ")).mapToInt(Integer::parseInt).toArray();

		LinkedList ll = new LinkedList();
		int j = 0;
        while (j < intArray1.length) {
            ll.addToFront(intArray1[j], intArray1[j + 1]);
			j = j + 2;
        }
		LinkedList ll2 = new LinkedList();
        System.out.println();
		int k = 0;
        while (k < intArray1.length) {
            ll2.addToFront(intArray2[k], intArray2[k + 1]);
			k = k + 2;
        }
		
		ll.insertionSort(ll.head);
		ll2.insertionSort(ll2.head);
		System.out.print("p1 = ");
		ll.printList();
		System.out.print("p2 = ");
		ll2.printList();
		newSum(ll.head, ll2.head);
		newSub(ll.head, ll2.head);
		multiPoly(ll.head, ll2.head);
		derivePoly(ll.head, ll2.head);
		}
		catch (Exception ie) {
			System.out.println("Error: Please try again");
		}
	}
}

/*
 * https://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
 * 
 */
