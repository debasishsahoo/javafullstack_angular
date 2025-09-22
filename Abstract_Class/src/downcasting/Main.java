package downcasting;

public class Main {

	public static void main(String[] args) {
		// Upcasting: Dog -> Animal
		Animal animal = new Dog();

		// Dynamic method dispatch calls Dog's makeSound()
		animal.makeSound(); // Output: Woof!

		// Downcasting: Animal -> Dog
		Dog dog = (Dog) animal; // Explicit cast required
		dog.wagTail(); // Output: Wagging tail

		// Unsafe downcasting example
		Animal genericAnimal = new Animal();
		try {
			Dog wrongDog = (Dog) genericAnimal; // Runtime error
			wrongDog.wagTail();
		} catch (ClassCastException e) {
			System.out.println("Error: Cannot cast Animal to Dog!");
		}

	}

}
