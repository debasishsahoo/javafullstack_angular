package MethodOverriding;

//Base class
class Shape1 {
	public void draw() {
		System.out.println("Drawing generic shape");
	}

	public double getArea() {
		return 0.0;
	}
}

//Rectangle subclass
class Rectangle1 extends Shape1 {
	private double length, width;

	public Rectangle1(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("Drawing rectangle");
	}

	@Override
	public double getArea() {
		return length * width;
	}
}

//Circle subclass
class Circle1 extends Shape1 {
	private double radius;

	public Circle1(double radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}

public class Rule5_6 {
	public static void main(String[] args) {
		Shape1 s1 = new Shape1();
		Shape1 s2 = new Rectangle1(5, 3);
		Shape1 s3 = new Circle1(4);

		s1.draw(); // Output: Drawing generic shape
		System.out.println("Area: " + s1.getArea()); // 0.0

		s2.draw(); // Output: Drawing rectangle
		System.out.println("Area: " + s2.getArea()); // 15.0

		s3.draw(); // Output: Drawing circle
		System.out.println("Area: " + s3.getArea()); // ~50.265
		
		
		System.out.println("");

		// Polymorphic behavior:
		Shape1[] shapes = { 
				new Rectangle1(5, 3), // Rectangle object
				new Circle1(4), // Circle object
				new Shape1() // Generic shape object
		};
		
		 for (Shape1 shape : shapes) {
	            shape.draw();   // Calls overridden draw()
	            System.out.println("Area: " + shape.getArea());
	            System.out.println();
	        }

	}
}

//1. **Method Overriding**:
//    - `Rectangle` and `Circle` **override** both `draw()` and `getArea()`.
//    - Parent reference (`Shape`) can call child methods due to **runtime polymorphism**.
//2. **Dynamic Binding**:
//    - Even though `s2` and `s3` are declared as `Shape`, at runtime Java decides which version of `draw()` and `getArea()` to call (child version).
//3. **Extensibility**:
//    - You can add more shapes (`Triangle`, `Square`, etc.) without modifying existing code — just override the methods.
//



//- **Runtime Polymorphism**:
//    
//    Even though the array type is `Shape[]`, at runtime Java determines which `draw()` and `getArea()` to execute (Rectangle’s, Circle’s, or Shape’s).
//    
//- This makes the program **flexible and extensible**: new shapes can be added without changing `TestPolymorphism`.


