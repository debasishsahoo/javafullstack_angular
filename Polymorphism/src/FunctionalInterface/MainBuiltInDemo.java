package FunctionalInterface;

//<T> function
import java.util.function.*;

public class MainBuiltInDemo{
	 public static void main(String[] args) {
		 
		 // Predicate -> condition check
	        Predicate<Integer> isEven = n -> n % 2 == 0;
	        System.out.println("Is 10 even? " + isEven.test(10));

	        // Function -> input -> output
	        Function<String, Integer> lengthFunc = str -> str.length();
	        System.out.println("Length of 'Functional': " + lengthFunc.apply("Functional"));

	        // Consumer -> consumes value
	        Consumer<String> printer = msg -> System.out.println("Message: " + msg);
	        printer.accept("Using Consumer to print");

	        // Supplier -> supplies value
	        Supplier<Double> randomValue = () -> Math.random();
	        System.out.println("Random value: " + randomValue.get());
		 
		 
		 
		 
		 
		 
	 }

}
