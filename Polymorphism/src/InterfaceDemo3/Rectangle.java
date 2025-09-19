package InterfaceDemo3;

public class Rectangle implements Drawable, Movable{
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
	        System.out.println("Drawing a " + color + " rectangle " + width + "x" + height + 
	                          " at position (" + x + ", " + y + ")");
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
