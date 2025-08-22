package com.example.other;

import com.example.original.BaseClass;

public class SubclassDifferentPackage extends BaseClass {
    public void testAccessViaInheritance() {
        System.out.println("\n=== SUBCLASS (DIFFERENT PACKAGE) - VIA INHERITANCE ===");
        
        // Only public and protected accessible via inheritance (this.)
        System.out.println("✓ Public: " + this.publicField);
        System.out.println("✓ Protected: " + this.protectedField);
        // System.out.println("✗ Default: " + this.defaultField);    // NOT accessible
        // System.out.println("✗ Private: " + this.privateField);    // NOT accessible
        
        this.publicMethod();
        this.protectedMethod();
        // this.defaultMethod();    // NOT accessible
        // this.privateMethod();    // NOT accessible
    }
    
    
    public void testAccessViaObject() {
        System.out.println("\n=== SUBCLASS (DIFFERENT PACKAGE) - VIA OBJECT ===");
        BaseClass obj = new BaseClass();
        
        // IMPORTANT: Protected NOT accessible via object reference, only via inheritance!
        System.out.println("✓ Public: " + obj.publicField);
        // System.out.println("✗ Protected: " + obj.protectedField);  // NOT accessible via object!
        // System.out.println("✗ Default: " + obj.defaultField);      // NOT accessible
        // System.out.println("✗ Private: " + obj.privateField);      // NOT accessible
        
        obj.publicMethod();
        // obj.protectedMethod();  // NOT accessible via object!
        // obj.defaultMethod();    // NOT accessible
        // obj.privateMethod();    // NOT accessible
        
        System.out.println("Note: Protected members accessible via 'this.' but NOT via 'obj.'");
    }
}