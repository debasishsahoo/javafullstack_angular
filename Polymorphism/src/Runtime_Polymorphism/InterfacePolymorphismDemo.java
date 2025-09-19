package Runtime_Polymorphism;

interface Drawable {
	void draw();

	default void showInfo() {
		System.out.println("This is a drawable object");
	}
}

interface Movable {
	void move(int x, int y);

	void stop();
}

interface Resizable {
	void resize(double factor);
}

//A shape that can be drawn
class Circle implements Drawable {
	private String color;
	private int radius;

	public Circle(String color, int radius) {
		this.color = color;
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a " + color + " circle with radius " + radius);
	}

	@Override
	public void showInfo() {
		System.out.println("Circle: " + color + ", radius: " + radius);
	}
}

class Rectangle implements Drawable, Movable {
	private String color;
	private int width, height;
	private int x, y;

	public Rectangle(String color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void draw() {
		System.out.println(
				"Drawing a " + color + " rectangle " + width + "x" + height + " at position (" + x + ", " + y + ")");
	}

	@Override
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Rectangle moved to (" + x + ", " + y + ")");
	}

	@Override
	public void stop() {
		System.out.println("Rectangle stopped at (" + x + ", " + y + ")");
	}
}

class Robot implements Drawable, Movable, Resizable {
	private String name;
	private double size;
	private int x, y;
	private boolean isMoving;

	public Robot(String name) {
		this.name = name;
		this.size = 1.0;
		this.x = 0;
		this.y = 0;
		this.isMoving = false;
	}

	@Override
	public void draw() {
		System.out.println("Drawing robot '" + name + "' (size: " + size + ") at (" + x + ", " + y + ")");
	}

	@Override
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		this.isMoving = true;
		System.out.println("Robot '" + name + "' moving to (" + x + ", " + y + ")");
	}

	@Override
	public void stop() {
		this.isMoving = false;
		System.out.println("Robot '" + name + "' stopped");
	}

	@Override
	public void resize(double factor) {
		this.size *= factor;
		System.out.println("Robot '" + name + "' resized to " + size);
	}
}

public class InterfacePolymorphismDemo {

}
