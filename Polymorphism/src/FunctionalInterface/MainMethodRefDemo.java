package FunctionalInterface;

@FunctionalInterface
interface Printer {
    void print(String message);
}

public class MainMethodRefDemo {
	 public static void main(String[] args) {
	        // Lambda way
	        Printer lambdaPrinter = msg -> System.out.println(msg);

	        // Method reference way
	        Printer methodRefPrinter = System.out::println;

	        lambdaPrinter.print("Hello using Lambda");
	        methodRefPrinter.print("Hello using Method Reference");
	    }
}
