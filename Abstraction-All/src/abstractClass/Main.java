package abstractClass;

//Benefits 
//Reduces complexity by hiding unnecessary details
//Increases code reusability and maintainability
//Provides a clear separation between interface and implementation
//Enhances security by hiding sensitive implementation details

public class Main {
//Characteristics 
//Cannot be instantiated - You cannot create objects directly from an abstract class
//Can have constructors - Used when subclasses are instantiated
//Can have both abstract and non-abstract methods	
//Can have instance variables (fields)	
//Can have static and final methods	
//Supports access modifiers - public, protected, private, default	
//Can extend only one class (single inheritance)	
//Must be inherited - A subclass must provide implementation for all abstract methods or be declared abstract itself	
	
	
	public static void main(String[] args) {
		//Animal animal = new Animal("Generic"); // ERROR: Cannot instantiate

		Animal dog = new Dog("Buddy");
		dog.makeSound(); // Output: Buddy says: Woof! Woof!
		dog.sleep(); // Output: Buddy is sleeping...

		Animal cat = new Cat("Whiskers");
		cat.makeSound(); // Output: Whiskers says: Meow! Meow!
		cat.eat(); // Output: Whiskers is eating...

	}

}
