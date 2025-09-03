package Hybrid_Inheritance;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Electric Autonomous Car Demo ===");
		// Create an instance of ElectricAutonomousCar
		ElectricAutonomousCar myCar = new ElectricAutonomousCar("Tesla", 2023, 100);

		// Methods inherited from Vehicle class
		myCar.startEngine();
		myCar.displayInfo();

		// Methods from ElectricPowered interface
		myCar.chargeBattery();
		System.out.println("Battery Capacity: " + myCar.getBatteryCapacity() + " kWh");
		myCar.displayEcoFriendlyMessage(); // Default method from interface

		// Methods from AutonomousDriving interface
		myCar.calibrateSensors();
		myCar.enableAutopilot();
		myCar.safetyCheck(); // Default method from interface

		// Method specific to ElectricAutonomousCar class
		myCar.displayTechSpecs();

		
		
		
		
		
		System.out.println("\n=== Polymorphism Example ===");

		// Using interface references
		ElectricPowered electricCar = myCar;
		electricCar.chargeBattery();

		AutonomousDriving autonomousCar = myCar;
		autonomousCar.enableAutopilot();

		// Using parent class reference
		Vehicle vehicle = myCar;
		vehicle.startEngine();

	}
}
