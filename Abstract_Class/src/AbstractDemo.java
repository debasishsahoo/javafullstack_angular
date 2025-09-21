

//you cannot create objects from it
//methods without implementation(abstract methods)
//methods with implementation(concrete methods)
//define a common base class(provide partial implementation)
//and leaves some methods to be implemented by subclasses.
//May contain constructors and static methods.
//Can have fields (variables).
//Supports inheritance (subclasses must implement abstract methods).
//Can extend another class (abstract or concrete).

abstract class Animal {
	// Abstract method (no implementation)
    public abstract void sound();
    
    // Concrete method
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
//Subclass Dog must implement sound()
class Dog extends Animal {
 public void sound() {
     System.out.println("Woof Woof!");
 }
}

//Subclass Cat must implement sound()
class Cat extends Animal {
 public void sound() {
     System.out.println("Meow Meow!");
 }
}
public class AbstractDemo{
	
	Animal a = new Animal(); 	
	
	
	
	
	
}