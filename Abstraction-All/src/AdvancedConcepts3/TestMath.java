package AdvancedConcepts3;

public class TestMath {
	 public static void main(String[] args) {
	        // Static method call without object
	        System.out.println("Sum: " + MathOperations.add(5, 3));
	        
	        MathOperations div = new Division();
	        div.printWelcome(); // Final method
	        double result = div.calculate(10, 2);
	        div.displayResult(result);
	    }
}
