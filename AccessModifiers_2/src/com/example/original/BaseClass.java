package com.example.original;

public class BaseClass {
    public String publicField = "Public field";
    protected String protectedField = "Protected field";
    String defaultField = "Default field";  // package-private
    private String privateField = "Private field";
    
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    
    void defaultMethod() {  // package-private
        System.out.println("Default method called");
    }
    
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    public BaseClass() {
        System.out.println("=== SAME CLASS ACCESS ===");
        // All members accessible within same class
        System.out.println("✓ Public: " + this.publicField);
        System.out.println("✓ Protected: " + this.protectedField);
        System.out.println("✓ Default: " + this.defaultField);
        System.out.println("✓ Private: " + this.privateField);
        
        this.publicMethod();
        this.protectedMethod();
        this.defaultMethod();
        this.privateMethod();
    }
}