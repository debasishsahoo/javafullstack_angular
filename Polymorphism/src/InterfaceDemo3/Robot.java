package InterfaceDemo3;

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

//Concrete classes
