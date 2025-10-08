package abstractMethods;

public abstract class Shape {
	String color;

	// Constructor
	public Shape(String color) {
		this.color = color;
	}

	// Abstract methods
	abstract double calculateArea();

	abstract double calculatePerimeter();

	// Concrete method
	public void displayColor() {
		System.out.println("Color: " + color);
	}

}
