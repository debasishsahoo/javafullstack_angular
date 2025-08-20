package com.example.original;

public class SamePackageClass {
	public void testAccess() {
        System.out.println("\\n=== Same Package Access ===");
        BaseClass obj = new BaseClass();
        
        // Accessible: public, protected, default
        System.out.println("Public: " + obj.publicField);
        System.out.println("Protected: " + obj.protectedField);
        System.out.println("Default: " + obj.defaultField);
        //System.out.println("Private: " + obj.privateField);  // Compilation Error
        
        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
        // obj.privateMethod();  // Compilation Error
    }
}
