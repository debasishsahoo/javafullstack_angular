package DMD;

public class DynamicDispatchAllSample {
	public static void main(String[] args) {
		// All references are of type Animal, but point to different object types
		Animal[] animals = { new Dog(), new Cat(), new Bird() };

		// Dynamic method dispatch in action
		for (Animal animal : animals) {
			// The JVM determines at runtime which makeSound() to call
			animal.makeSound(); // Calls the overridden method in each subclass
			animal.sleep(); // Calls the inherited method from Animal class
			System.out.println("---");
		}

		// More specific example
		Animal myPet = new Dog(); // Reference type: Animal, Object type: Dog
		myPet.makeSound(); // Output: "Dog barks: Woof!" (not Animal's version)

		// This would cause compile-time error because fetch() is not in Animal class
		// myPet.fetch(); // Compilation error

		// But we can cast if we know the actual type
		if (myPet instanceof Dog) {
			((Dog) myPet).fetch(); // Now we can call Dog-specific methods
		}
	}
}
