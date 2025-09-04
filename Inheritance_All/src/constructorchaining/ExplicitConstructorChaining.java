package constructorchaining;

class Vehicle {
    protected String brand;
    protected int year;

    // Default constructor(No-Args constructor)
    public Vehicle() {
        System.out.println("Default vehicle constructor");
    }

    // Parameterized constructor(Args constructor)
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Parameterized vehicle constructor: " + brand + " " + year);
    }
}


class Car extends Vehicle {
	 private int doors;
	 
	// Default constructor
	    public Car() {
	        super();  // Calls Vehicle() //if this not present Here then JVM Will put super() here
	        System.out.println("Default car constructor");
	    }
	    
	 // Parameterized constructor
	    public Car(String brand, int year, int doors) {
	        super(brand, year);  // Calls Vehicle(String, int), Explicitly Call by user
	        this.doors = doors;
	        System.out.println("Parameterized car constructor: " + doors + " doors");
	    }
}


public class ExplicitConstructorChaining {

	public static void main(String[] args) {
		System.out.println("=== Creating Car with default constructor ===");
		  Car car1 = new Car();
		
		System.out.println("\n=== Creating Car with parameterized constructor ===");
		Car car2 = new Car("Toyota", 2022, 4);

	}

}

//### When `new Car()` is called:
//
//- `super();` invokes `Vehicle()` → prints `"Default vehicle constructor"`
//- Then `Car()` runs → prints `"Default car constructor"`
//
//### When `new Car("Toyota", 2022, 4)` is called:
//
//- `super(brand, year);` invokes `Vehicle(String, int)` → prints `"Parameterized vehicle constructor: Toyota 2022"`
//- Then `Car(String, int, int)` runs → prints `"Parameterized car constructor: 4 doors"`









