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
		Animal puppy = dog.getOffspring(); // Returns Dog, not Animal
		puppy.makeSound();

		System.out.println("\n=== Compile-time vs Runtime Type ===");
		Animal animalRef = new Dog();
		// animalRef.wagTail(); // Compilation error - wagTail() not in Animal class\

		// We can cast to access Dog-specific methods
		if (animalRef instanceof Dog) {
			Dog dogRef = (Dog) animalRef;
			dogRef.wagTail(); // Now this works
		}

		// Dynamic method dispatch in action
		demonstratePolymorphism(new Dog());
		demonstratePolymorphism(new Cat());
		demonstratePolymorphism(new Animal());

	}

	// This method works with any Animal type due to polymorphism
	public static void demonstratePolymorphism(Animal animal) {
		System.out.println("\nPolymorphism in action:");
		System.out.println("Actual object type: " + animal.getClass().getSimpleName());
		animal.makeSound(); // Calls appropriate overridden method
	}

}



//Signature Rules:
//- Method name must be exactly the same
//- Parameter list must be identical (same number, types, and order)
//- Return type must be the same or a covariant return type (subtype of the original return type)

//The JVM looks at the actual object type (not the reference type) 
//to determine which method implementation to call

//Method Resolution: The JVM starts from the actual 
//object's class and searches up the inheritance hierarchy until it finds the method implementation














