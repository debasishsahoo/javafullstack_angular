package InterfaceDemo3;

//Utility class demonstrating polymorphism with interfaces
class GraphicsEngine {

	// Method that works with any Drawable object
	public static void renderDrawable(Drawable drawable) {
		System.out.println("Rendering drawable object:");
		drawable.showInfo();
		drawable.draw();
		System.out.println();
	}
	// Method that works with any Movable object
    public static void animateMovable(Movable movable) {
        System.out.println("Animating movable object:");
        movable.move(100, 50);
        movable.move(200, 100);
        movable.stop();
        System.out.println();
    }
    
 // Method demonstrating polymorphism with arrays
    public static void renderAll(Drawable[] drawables) {
        System.out.println("Rendering all drawable objects:");
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
        System.out.println();
    }

}
