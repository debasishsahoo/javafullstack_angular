package com.example.other;

import com.example.original.BaseClass;

public class OtherPackageClass {
    public void testAccess() {
        System.out.println("\n=== OTHER PACKAGE (NON-SUBCLASS) ACCESS ===");
        BaseClass obj = new BaseClass();
        
        // Only public accessible
        System.out.println("✓ Public: " + obj.publicField);
        // System.out.println("✗ Protected: " + obj.protectedField);  // NOT accessible
        // System.out.println("✗ Default: " + obj.defaultField);      // NOT accessible  
        // System.out.println("✗ Private: " + obj.privateField);      // NOT accessible
        
        obj.publicMethod();
        // obj.protectedMethod();  // NOT accessible
        // obj.defaultMethod();    // NOT accessible
        // obj.privateMethod();    // NOT accessible
    }
}