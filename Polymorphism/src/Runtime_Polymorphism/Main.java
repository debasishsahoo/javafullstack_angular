package Runtime_Polymorphism;

public class Main {

	public static void main(String[] args) {
		Vehicle genericVehicle = new Vehicle("GenericBrand", 2000);
		Car car = new Car("Toyota", 2022, 4);
		Motorcycle motorcycle = new Motorcycle("Harley-Davidson", 2021, false);

		System.out.println("=== Start Vehicles ===");
		genericVehicle.start();
		car.start();
		motorcycle.start();

		System.out.println("\n=== Maintenance ===");
		genericVehicle.maintenance();
		car.maintenance();
		motorcycle.maintenance();

		System.out.println("\n=== Display Info (final method) ===");
		genericVehicle.displayInfo();
		car.displayInfo();
		motorcycle.displayInfo();

		System.out.println("\n=== Static Method Calls ===");
		Vehicle.getVehicleCount(); // Calls Vehicle's static method
		Car.getVehicleCount(); // Calls Car's static method

		System.out.println("\n=== Car-specific method ===");
		car.openTrunk();

	}

}
