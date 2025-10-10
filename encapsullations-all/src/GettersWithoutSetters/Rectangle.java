package GettersWithoutSetters;

public class Rectangle {
	private double width;
	private double height;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	// Computed property - no setter needed
    public double getArea() {
        return width * height;
    }
    
    // Another computed property
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
