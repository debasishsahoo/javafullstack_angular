package abstractMethods;

public class Main {
	//Characteristics 
	//No method body - Declaration only, no implementation
	//Must be in abstract class or interface
	//Cannot be private - Must be inherited and overridden
	//Cannot be static - Static methods cannot be overridden
	//Cannot be final - Final methods cannot be overridden
	//Must be overridden - Subclasses must provide implementation
	//Can have access modifiers - public, protected, or default (not private)
	

	public static void main(String[] args) {
		Shape circle = new Circle("Red", 5.0);
        circle.displayColor();
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        
        Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());

	}

}
