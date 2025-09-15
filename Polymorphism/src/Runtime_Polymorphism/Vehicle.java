package Runtime_Polymorphism;

//Method Overriding 
public class Vehicle {
	protected String brand;
	protected int year;

	public Vehicle(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}

	// Method to be overridden
	public void start() {
		System.out.println("Vehicle is starting...");
	}

	// Method with different access modifiers
	protected void maintenance() {
		System.out.println("General maintenance required");
	}

	// Final method cannot be overridden
	public final void displayInfo() {
		System.out.println("Brand: " + brand + ", Year: " + year);
	}

	// Static method - method hiding, not overriding
	public static void getVehicleCount() {
		System.out.println("Total vehicles manufactured");
	}
}
