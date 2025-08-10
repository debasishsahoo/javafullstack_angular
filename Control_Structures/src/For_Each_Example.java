
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class For_Each_Example {

	public static void main(String[] args) {
		 // Array of integers
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Traditional for loop
        System.out.print("Traditional for loop: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        
    
        // For-Each loop (Enhanced for loop)
        System.out.print("For-Each loop: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n");
        
        
         // String array
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        System.out.println("Names:");
        for (String name : names) {
            System.out.println("  - " + name);
        }
        
        
        
     // 2.1 ArrayList
        System.out.println("2.1 ArrayList:");
        
        List<String> cities = new ArrayList<>(Arrays.asList("New York", "London", "Tokyo", "Paris"));
        
        for (String city : cities) {
            System.out.println("  City: " + city);
        }
        
        
        
        
        
        
        

	}

}
