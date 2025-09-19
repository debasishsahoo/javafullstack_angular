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


public class InterfacePolymorphismDemo {

}
