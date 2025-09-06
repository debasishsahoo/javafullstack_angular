
public class Window {
	private String title;
	public Window(String title) {
		 this.title = title;
		// Register this window with window manager
		 WindowManager.register(this); // Passing current object
	}
	
	public void addClickListener() {
        // Passing current object as event listener
        Button button = new Button();
        button.setOnClick(this);  // If Window implements ClickListener
    }
}
