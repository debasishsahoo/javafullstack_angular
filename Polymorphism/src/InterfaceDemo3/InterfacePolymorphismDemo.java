package InterfaceDemo3;

public class InterfacePolymorphismDemo {

	public static void main(String[] args) {
		System.out.println("=== Interface Polymorphism Demo ===\n");
		// Creating objects of different classes
		Circle circle = new Circle("red", 5);
		Rectangle rectangle = new Rectangle("blue", 10, 15);
		Robot robot = new Robot("R2D2");

		// Polymorphism through interface references
		System.out.println("1. Single Interface Polymorphism:");
		Drawable drawable1 = circle; // Circle as Drawable
		Drawable drawable2 = rectangle; // Rectangle as Drawable
		Drawable drawable3 = robot; // Robot as Drawable

		drawable1.draw();
		drawable2.draw();
		drawable3.draw();
		System.out.println();

		// Multiple interface implementation
		System.out.println("2. Multiple Interface Implementation:");
		Movable movableRect = rectangle; // Rectangle as Movable
		Movable movableRobot = robot; // Robot as Movable

		movableRect.move(25, 30);
		movableRobot.move(50, 75);
		System.out.println();

		// Array polymorphism with interfaces
		System.out.println("3. Array Polymorphism:");
		Drawable[] drawables = { circle, rectangle, robot };
		GraphicsEngine.renderAll(drawables);

		// Method polymorphism with interfaces
		System.out.println("4. Method Polymorphism:");
		GraphicsEngine.renderDrawable(circle);
		GraphicsEngine.renderDrawable(rectangle);
		GraphicsEngine.renderDrawable(robot);

		GraphicsEngine.animateMovable(rectangle);
		GraphicsEngine.animateMovable(robot);

		// Demonstrating multiple interfaces on same object
		System.out.println("5. Single Object, Multiple Interface Types:");
		Robot multiRobot = new Robot("Mule");

		// Same object referenced through different interface types
		Drawable drawableRobot = multiRobot;
		Movable movableRobot2 = multiRobot;
		Resizable resizableRobot = multiRobot;
		
		drawableRobot.draw();
        movableRobot2.move(10, 20);
        resizableRobot.resize(1.5);
        movableRobot2.stop();
        System.out.println();
        
        // Functional interface polymorphism (lambdas)
        System.out.println("6. Functional Interface Polymorphism:");
        demonstrateFunctionalPolymorphism();

	}
	// Demonstrating polymorphism with functional interfaces and lambdas
    public static void demonstrateFunctionalPolymorphism() {
        // Different implementations of the same functional interface
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;
        Calculator division = (a, b) -> b != 0 ? a / b : 0;
        
        // Method reference as another implementation
        Calculator subtraction = Double::sum; // This would be (a, b) -> a - b for actual subtraction
        // Let's create proper subtraction
        Calculator actualSubtraction = (a, b) -> a - b;
        
        // Array of Calculator implementations
        Calculator[] calculators = {addition, multiplication, division, actualSubtraction};
        String[] operations = {"Addition", "Multiplication", "Division", "Subtraction"};
        
        double x = 10.0, y = 3.0;
        
        // Polymorphic behavior with functional interfaces
        for (int i = 0; i < calculators.length; i++) {
            double result = calculators[i].calculate(x, y);
            System.out.println(operations[i] + ": " + x + " and " + y + " = " + result);
        }
        
        // Using polymorphism in method calls
        System.out.println("\nUsing calculator polymorphism:");
        performCalculation(addition, 15.0, 25.0, "Adding");
        performCalculation(multiplication, 4.0, 7.0, "Multiplying");
    }
 // Method that accepts any Calculator implementation
    public static void performCalculation(Calculator calc, double a, double b, String operation) {
        double result = calc.calculate(a, b);
        System.out.println(operation + " " + a + " and " + b + " gives: " + result);
    }
}
