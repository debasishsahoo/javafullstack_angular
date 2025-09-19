package InterfaceDemo3;

 class Circle implements Drawable{
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
