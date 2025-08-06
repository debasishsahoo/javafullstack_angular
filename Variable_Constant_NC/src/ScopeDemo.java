
public class ScopeDemo {
	// Instance variable
    private int instanceCount = 0;
    
    // Static constant
    public static final String APP_NAME = "ScopeDemo";
    
    
    public void increment() {
        int localCounter = 5;  // Local variable
        localCounter++;
        instanceCount++;
        System.out.println("localCounter: " + localCounter);
    }
    
   
	public static void main(String[] args) {
		ScopeDemo demo = new ScopeDemo();
        demo.increment();
        
        // System.out.println(localCounter); // ERROR - out of scope
        System.out.println("Instance count: " + demo.instanceCount);
        //System.out.println("localCounter: " + demo.localCounter);
        System.out.println("App: " + ScopeDemo.APP_NAME);
	}

}
