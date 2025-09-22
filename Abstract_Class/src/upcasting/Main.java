package upcasting;

public class Main {
	public static void main(String[] args) {
		// Creating Dog object
        Dog dog = new Dog();
        // Upcasting - Dog reference is assigned to Animal type
        Animal animal = dog;  // Implicit conversion (safe)

        // Calls Dog's overridden method due to dynamic method dispatch
        animal.makeSound();   // Output: Woof!

        
        //animal.wagTail(); //ERROR: wagTail() not defined in Animal
        // Even though the object is Dog, reference type is Animal, so only Animal's methods are accessible

        // If we need Dog-specific method, we must downcast back to Dog
        Dog downcastedDog = (Dog) animal;  //(int)10.5
        downcastedDog.wagTail();  // Output: Wagging tail
	}
}
