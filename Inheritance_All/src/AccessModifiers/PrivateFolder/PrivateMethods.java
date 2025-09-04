package AccessModifiers.PrivateFolder;

class Parent3 {
    private void hiddenMethod() {
        System.out.println("Parent's private method");
    }
    
    public void callHidden() {
        hiddenMethod(); // Always calls Parent's version
    }
}

class Child3 extends Parent3 {
    // This is NOT an override - it's a new method
    private void hiddenMethod() {
        System.out.println("Child's new method");
    }
    
    public void test() {
        callHidden();    // Calls Parent's version
        hiddenMethod();  // Calls Child's new method
    }
}





public class PrivateMethods {
	public static void main(String[] args) {
        Child3 child = new Child3();
        child.test();
    }
}
