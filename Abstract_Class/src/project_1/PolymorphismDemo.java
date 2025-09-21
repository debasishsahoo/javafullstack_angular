package project_1;
// Demonstration class
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Create array of Animal references pointing to different objects
        Animal[] animals = {
            new Dog("Buddy", 3, "Golden Retriever"),
            new Bird("Tweet", 1, true),
            new Fish("Nemo", 2, "salt"),
            new Bird("Penguin", 5, false)
        };
        
        System.out.println("=== Polymorphism in Action ===\n");
        
        // Polymorphic behavior - same method calls, different implementations
        for (Animal animal : animals) {
            System.out.println("--- " + animal.getInfo() + " ---");
            animal.makeSound();    // Calls overridden method based on actual object type
            animal.move();         // Polymorphic method call
            animal.eat("treats");  // Different eating behavior for each animal
            animal.sleep();        // Inherited method from abstract class
            System.out.println();
        }
        
        System.out.println("=== Method Overloading with Polymorphism ===\n");
        
        // Demonstrate polymorphic method calls
        performAnimalActions(new Dog("Rex", 4, "German Shepherd"));
        performAnimalActions(new Bird("Eagle", 8, true));
        performAnimalActions(new Fish("Goldy", 1, "fresh"));
        
        System.out.println("=== Runtime Type Checking ===\n");
        

        
        // This would cause a compilation error:
        // Animal abstractAnimal = new Animal("Test", 1); // Cannot instantiate abstract class
    }
    
    // Method that accepts any Animal (polymorphism)
    public static void performAnimalActions(Animal animal) {
        System.out.println("Performing actions for: " + animal.name);
        animal.makeSound();
        animal.move();
        
        // Runtime type checking for specific behaviors
        if (animal instanceof Dog) {
            ((Dog) animal).wagTail(); // Downcast to access Dog-specific method
        } else if (animal instanceof Bird) {
            ((Bird) animal).buildNest(); // Downcast to access Bird-specific method
        }
        System.out.println();
    }
    
    // Method demonstrating instanceof with polymorphism
    public static void checkAnimalType(Animal animal) {
        System.out.print(animal.name + " is a ");
        
        if (animal instanceof Dog) {
            System.out.println("Dog");
        } else if (animal instanceof Bird) {
            System.out.println("Bird");
        } else if (animal instanceof Fish) {
            System.out.println("Fish");
        }
        
        // All are instances of Animal due to inheritance
        System.out.println("Is " + animal.name + " an Animal? " + (animal instanceof Animal));
        System.out.println();
    }
}
