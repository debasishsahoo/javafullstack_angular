package com.example.package1;

/**
 * Main class demonstrating all access modifiers
 * This represents the base class for testing access levels
 */
public class AccessModifierDemo {
    
    // Public - accessible everywhere (column 4 in table: all 1s)
    public int publicVariable = 1;
    public static final String PUBLIC_CONSTANT = "Public Constant";
    
    // Protected - accessible in same package and subclasses (column 3: 1,1,1,0)
    protected int protectedVariable = 2;
    protected String protectedMessage = "Protected Message";
    
    // Package-private/Default - accessible only in same package (column 2: 1,1,0,0)
    int packagePrivateVariable = 3;
    String packagePrivateMessage = "Package Private Message";
    
    // Private - accessible only within same class (column 1: 1,0,0,0)
    private int privateVariable = 4;
    private String privateMessage = "Private Message";
    
    // Public constructor
    public AccessModifierDemo() {
        System.out.println("AccessModifierDemo constructor called");
    }
    
    // Public method demonstrating access within same class
    public void demonstrateSameClassAccess() {
        System.out.println("=== Access within Same Class (All 1s) ===");
        // All members accessible within same class
        System.out.println("Private: " + privateVariable + " - " + privateMessage);
        System.out.println("Package: " + packagePrivateVariable + " - " + packagePrivateMessage);
        System.out.println("Protected: " + protectedVariable + " - " + protectedMessage);
        System.out.println("Public: " + publicVariable + " - " + PUBLIC_CONSTANT);
        
        // Call all methods
        privateMethod();
        packagePrivateMethod();
        protectedMethod();
        publicMethod();
    }
    
    // Method with each access modifier
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    
    void packagePrivateMethod() {
        System.out.println("Package-private method called");
    }
    
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    // Getter methods for demonstration
    public int getPrivateVariable() {
        return privateVariable;
    }
    
    public String getPrivateMessage() {
        return privateMessage;
    }
}