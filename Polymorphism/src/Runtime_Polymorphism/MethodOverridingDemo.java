package Runtime_Polymorphism;

public class MethodOverridingDemo {

	public static void main(String[] args) {
		// Runtime polymorphism demonstration
		System.out.println("=== Runtime Polymorphism Demo ===");

		// Reference type is Animal, but actual objects are Dog and Cat
		Animal animal1 = new Dog();
		Animal animal2 = new Cat();
		Animal animal3 = new Animal();

		// Array of Animal references pointing to different object types
		Animal[] animals = { animal1, animal2, animal3 };

		// Same method call, different behavior based on actual object type
		for (Animal animal : animals) {
			animal.makeSound(); // Calls overridden method based on actual object
			animal.sleep();
			System.out.println("---");
		}

		System.out.println("=== Method Resolution Demo ===");
		// Direct object creation and method calling
		Dog dog = new Dog();
		dog.makeSound(); // Calls Dog's overridden method
		dog.wagTail(); // Calls Dog-specific method
		
		// Demonstrating covariant return type
        Dog puppy = dog.getOffspring(); // Returns Dog, not Animal
        puppy.makeSound();

	}

}
