package staticAll;

public class OuterClass {
	private static String staticField = "Static field";
    private String instanceField = "Instance field";
    
    static class StaticNestedClass {
        void display() {
            System.out.println(staticField);        // OK
            // System.out.println(instanceField);   // Compilation error
        }
    }
    
   //Static nested classes don't need a reference to the 
    //outer class instance and cannot access non-static members of the outer class directly. 
}
