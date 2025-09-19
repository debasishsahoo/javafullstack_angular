package InterfaceDemo3;

interface Drawable {
	void draw();

	default void showInfo() {
		System.out.println("This is a drawable object");
	}
}
