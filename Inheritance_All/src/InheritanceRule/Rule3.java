package InheritanceRule;

class Vehicle {
	private String type;

	// Parent constructor
	Vehicle(String type) {
		this.type = type;
		System.out.println("Vehicle constructor: " + type);
	}
}

class Car extends Vehicle {
	private String model;

	// Child constructor MUST call parent constructor
	Car(String type, String model) {
		super(type);// Must call parent constructor

		this.model = model;
		System.out.println("Car constructor: " + model);
	};

	// This would cause error - no default constructor in Vehicle
	// Car() { } // ❌ COMPILATION ERROR
}

public class Rule3 {
	public static void main(String[] args) {
		Car myCar = new Car("Automobile", "Sedan");
	}
}
