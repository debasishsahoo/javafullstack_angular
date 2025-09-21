```java
// Abstract base class - cannot be instantiated
abstract class Animal {
    protected String name;
    protected int age;
    
    // Constructor for abstract class
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete method - shared implementation
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
    
    // Concrete method with common behavior
    public String getInfo() {
        return "Name: " + name + ", Age: " + age;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    
    // Abstract method for movement
    public abstract void move();
    
    // Abstract method for feeding
    public abstract void eat(String food);
}

// Concrete subclass 1
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
    
    @Override
    public void eat(String food) {
        System.out.println(name + " eagerly eats " + food);
    }
    
    // Dog-specific method
    public void wagTail() {
        System.out.println(name + " wags tail excitedly!");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", Breed: " + breed;
    }
}

// Concrete subclass 2
class Bird extends Animal {
    private boolean canFly;
    
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " flies through the air");
        } else {
            System.out.println(name + " hops on the ground");
        }
    }
    
    @Override
    public void eat(String food) {
        System.out.println(name + " pecks at " + food);
    }
    
    // Bird-specific method
    public void buildNest() {
        System.out.println(name + " builds a cozy nest");
    }
}

// Concrete subclass 3
class Fish extends Animal {
    private String waterType;
    
    public Fish(String name, int age, String waterType) {
        super(name, age);
        this.waterType = waterType;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " makes bubbles: Blub blub...");
    }
    
    @Override
    public void move() {
        System.out.println(name + " swims gracefully in " + waterType + " water");
    }
    
    @Override
    public void eat(String food) {
        System.out.println(name + " gulps down " + food);
    }
}

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
```