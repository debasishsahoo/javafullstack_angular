
public class GeometryCalculator {
	// CONSTANT (static final)
	static final double PI = 3.14159;

	public static void main(String[] args) {
		// Variables (primitive types)
		double radius = 5.0;
		final double HEIGHT = 10.0; // Local constant

		// Calculate circle area
		double circleArea = PI * radius * radius;
		System.out.println("Circle Area: " + circleArea);

		// Calculate cylinder volume
		double cylinderVolume = circleArea * HEIGHT;
		System.out.println("Cylinder Volume: " + cylinderVolume);
	}

}
