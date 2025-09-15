package Runtime_Polymorphism;

public class Car extends Vehicle {
	private int doors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }
    
 // Overriding with same signature
    @Override
    public void start() {
        System.out.println("Car engine is starting with ignition key...");
    }

    // Overriding with wider access modifier (protected to public)
    @Override
    public void maintenance() {
        System.out.println("Car maintenance: Oil change, tire rotation");
    }

    // Method hiding (static method)
    public static void getVehicleCount() {
        System.out.println("Total cars manufactured");
    }

    // Car-specific method
    public void openTrunk() {
        System.out.println("Trunk is opened");
    }
    
    
    
    
    
    
}
