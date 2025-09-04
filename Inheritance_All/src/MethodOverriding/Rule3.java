package MethodOverriding;

//Base class
class Shape {
	public void draw() {
		System.out.println("Drawing a Shape");
	}
}

//Subclass of Shape
class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}
}





//Factory class returning Shape
class ShapeFactory {
	public Shape createShape() {
		return new Shape(); // returns a generic Shape
	}
}

//Child factory overriding with covariant return type
class CircleFactory extends ShapeFactory {
	@Override
	public Circle createShape() { // Covariant return type (Circle ⊂ Shape)
		return new Circle(); // returns a Circle instead of just a Shape
	}
}

public class Rule3 {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		ShapeFactory circleFactory = new CircleFactory();
		
		Shape shape1 = shapeFactory.createShape();
		//Shape shape1 =new Shape();
		
		Shape shape2 = circleFactory.createShape(); // returns Circle object
		//Shape shape2 =new Circle();
		

		shape1.draw(); // Output: Drawing a Shape
		shape2.draw(); // Output: Drawing a Circle
	}
}



//### **Rule Demonstrated**
//
//- In overriding, **return types must be the same** OR a **subclass of the parent’s return type** (covariant).
//- This allows more flexibility:
//    - Parent’s method → `Shape`
//    - Child’s method → `Circle` (a subtype of `Shape`)
















