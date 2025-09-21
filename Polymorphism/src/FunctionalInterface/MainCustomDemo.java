package FunctionalInterface;

public class MainCustomDemo {

	public static void main(String[] args) {
		// Lambda for addition
        Calculator add = (x, y) -> x + y;

        // Lambda for multiplication
        Calculator multiply = (x, y) -> x * y;

        System.out.println("Addition: " + add.operate(5, 3));
        System.out.println("Multiplication: " + multiply.operate(5, 3));

        // Greeter Example
        Greeter greeter = (name) -> System.out.println("Hi, " + name);
        greeter.greet("Debasish");
        greeter.sayHello();   // default method
        Greeter.info();       // static method

	}

}
