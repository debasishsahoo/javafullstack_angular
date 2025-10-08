package abstractMethods;

public class Rectangle extends Shape {
	 double length, width;
	    
	    public Rectangle(String color, double length, double width) {
	        super(color);
	        this.length = length;
	        this.width = width;
	    }
	    
	    @Override
	    double calculateArea() {
	        return length * width;
	    }
	    
	    @Override
	    double calculatePerimeter() {
	        return 2 * (length + width);
	    }
}
