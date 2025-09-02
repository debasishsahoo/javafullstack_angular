package typeofClass;

class Vehicle {// Base Class or Parent Class or SUPERCLASS

	// Common state for all vehicles
	protected String brand; // 'protected' allows access by subclasses
	protected int year;

	public Vehicle(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}

	// Common behavior for all vehicles
	public void start() {
		System.out.println("Vehicle is starting");
	}

	public void move() {
		System.out.println("The vehicle is moving.");
	}

	public void displayInfo() {
		System.out.println("Brand: " + brand + ", Year: " + year);
	}
}
