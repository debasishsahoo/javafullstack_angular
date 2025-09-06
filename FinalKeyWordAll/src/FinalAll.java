

//The final keyword in Java is a powerful modifier that restricts modification in different contexts.
public class FinalAll {
	//Local Variables
	final int x = 10;
	// x = 20; // Compilation error - cannot reassign
	
	//Instance Variables
	final int value = 100;
    final String name; // Must be initialized in constructor
    
    
    public FinalAll(String name) {
        this.name = name; // OK - first assignment
    }
    
    public static final double PI = 3.14159;    //Constants
    public static final String APP_NAME = "MyApp"; //Constants
    
    
    final void display() {
        System.out.println("Cannot be overridden");
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
