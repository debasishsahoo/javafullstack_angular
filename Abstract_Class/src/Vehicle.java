
abstract class Vehicle {
	String brand;
	int year;

	// Constructor
	Vehicle(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}

	// Abstract method
	abstract void start();

	// Concrete method
	void showDetails() {
		System.out.println("Brand: " + brand + ", Year: " + year);
	}
}

//Car class extending Vehicle
class Car extends Vehicle {
	Car(String brand, int year) {
		super(brand, year);
	}

	// Implement abstract method
	void start() {
		System.out.println("Car " + brand + " is starting with a key...");
	}
}

class Bike extends Vehicle {
	Bike(String brand, int year) {
		super(brand, year);
	}

	// Implement abstract method
	void start() {
		System.out.println("Bike " + brand + " is starting with a kick...");
	}
}
