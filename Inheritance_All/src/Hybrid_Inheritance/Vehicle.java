package Hybrid_Inheritance;

class Vehicle {
	protected String manufacturer;
	protected int year;

	public Vehicle(String manufacturer, int year) {
		this.manufacturer = manufacturer;
		this.year = year;
	}

	public void startEngine() {
		System.out.println(manufacturer + " vehicle engine starting...");
	}

	public void displayInfo() {
		System.out.println("Manufacturer: " + manufacturer + ", Year: " + year);
	}
}
