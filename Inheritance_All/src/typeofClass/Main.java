package typeofClass;

public class Main {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("Generic Vehicle", 2020);
		System.out.println("=== Vehicle Object ===");
		vehicle.start(); // Calls Vehicle's start()
		vehicle.move(); // Calls Vehicle's move()
		vehicle.displayInfo(); // Vehicle details
		
		
		
		System.out.println();
		
		
		
		// Create a Car object (subclass of Vehicle)
		Car car = new Car("Toyota", 2022, 4);
		System.out.println("=== Car Object ===");
        car.start();             // Calls Car's overridden start()
        car.move();              // Calls Car's overridden move()
        car.honk();              // Car's specific behavior
        car.displayInfo();       // Inherited method
        car.displayDetails();    // Car's own method
	}
}
