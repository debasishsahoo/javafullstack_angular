package com.example.package1;

public class Child extends Parent{
	public void demonstrateInheritanceAccess() {
        System.out.println("\n=== Inheritance Access Demo ===");
        
        // Can access public members
        System.out.println("Public: " + publicInheritance);
        publicParentMethod();
        
        // Can access protected members
        System.out.println("Protected: " + protectedInheritance);
        protectedParentMethod();
        
        // Can access default members (same package)
        System.out.println("Default: " + defaultInheritance);
        defaultParentMethod();
        
        // CANNOT access private members
        //System.out.println("Private: " + privateInheritance); // Compilation error
        // privateParentMethod(); // Compilation error
        
        //Parent p1=new Parent();
        //System.out.println("Private: " + p1.privateInheritance);
    }
}
