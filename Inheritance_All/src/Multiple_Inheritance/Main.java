package Multiple_Inheritance;

public class Main {

	public static void main(String[] args) {
		//Dog dog = new Dog();
		
		Duck duck = new Duck();
        duck.run();    // From CanRun interface
        duck.swim();   // From CanSwim interface
        duck.quack();  // From Duck class
        System.out.println("\nDuck demonstrates multiple inheritance through interfaces");

	}

}

//Java doesn't support multiple inheritance with classes to avoid ambiguity
