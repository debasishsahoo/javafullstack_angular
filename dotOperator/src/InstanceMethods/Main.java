package InstanceMethods;

public class Main {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		// Accessing instance methods using dot operator
		calc.add(10, 5); // Calling add method
		double value = calc.getResult(); // Calling getResult method
		calc.reset(); // Calling reset method
	}
}
