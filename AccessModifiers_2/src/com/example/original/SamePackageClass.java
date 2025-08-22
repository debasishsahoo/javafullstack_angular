package com.example.original;

public class SamePackageClass {
	
	
    public void testAccess() {
        System.out.println("\n=== SAME PACKAGE ACCESS ===");
        BaseClass obj = new BaseClass();
        
        // public, protected, default accessible
        System.out.println("✓ Public: " + obj.publicField);
        System.out.println("✓ Protected: " + obj.protectedField);
        System.out.println("✓ Default: " + obj.defaultField);
         //System.out.println("✗ Private: " + obj.privateField);  // NOT accessible
        
        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
         //obj.privateMethod();  // NOT accessible
    }
}