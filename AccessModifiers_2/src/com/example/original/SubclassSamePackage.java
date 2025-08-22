package com.example.original;

public class SubclassSamePackage extends BaseClass {
    public void testAccess() {
        System.out.println("\n=== SUBCLASS (SAME PACKAGE) ACCESS ===");
        
        // All except private accessible
        System.out.println("✓ Public: " + this.publicField);
        System.out.println("✓ Protected: " + this.protectedField);
        System.out.println("✓ Default: " + this.defaultField);
        // System.out.println("✗ Private: " + this.privateField);  // NOT accessible
        
        this.publicMethod();
        this.protectedMethod();
        this.defaultMethod();
        // this.privateMethod();  // NOT accessible
    }
}