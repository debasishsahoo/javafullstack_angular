package AccessingArrays;

public class ArrayExample {
	  public static void main(String[] args) {
	        int[] numbers = {1, 2, 3, 4, 5};

	        // Accessing array length property
	        System.out.println("Array length: " + numbers.length);

	        String[] names = {"Alice", "Bob", "Charlie"};

	        // Accessing methods of array elements
	        System.out.println("First name length: " + names[0].length());
	        System.out.println("Uppercase: " + names[1].toUpperCase());
	    }
}
