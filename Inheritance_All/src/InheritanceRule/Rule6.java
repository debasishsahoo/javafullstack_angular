package InheritanceRule;
class Shape {
    protected String color;

    Shape(String color) {
        this.color = color;
    }

    void draw() {
        System.out.println("Drawing a " + color + " shape");
    }
}

class Circle extends Shape {
	private double radius;
	
	Circle(String color, double radius) {
        super(color); // Call parent constructor
        this.radius = radius;
    }
	
	@Override
    void draw() {
        super.draw(); // Call parent's draw method
        System.out.println("Drawing a circle with radius " + radius);
    }

    void display() {
        System.out.println("Color: " + super.color); // Access parent field
    }
	
	
	
	
}




public class Rule6 {

}
