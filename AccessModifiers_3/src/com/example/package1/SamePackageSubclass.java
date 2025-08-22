package com.example.package1;

/**
 * Subclass in the same package as AccessModifierDemo
 * Demonstrates access pattern: 0,1,1,1 (same as regular same-package class)
 */
public class SamePackageSubclass extends AccessModifierDemo {
    
    public SamePackageSubclass() {
        super();
        System.out.println("SamePackageSubclass constructor called");
    }
    
    public void testInheritedAccess() {
        System.out.println("\n=== Access from Same Package Subclass (0,1,1,1) ===");
        
        // Private: NOT accessible even in subclass (0)
        // System.out.println(privateVariable); // ✗ Compilation error
        // privateMethod(); // ✗ Compilation error
        System.out.println("Private: Not accessible - using inherited getter: " + getPrivateVariable());
        
        // Package-private: Accessible (1)
        System.out.println("Package: " + packagePrivateVariable + " - " + packagePrivateMessage);
        packagePrivateMethod();
        
        // Protected: Accessible (1) - can access directly as inherited member
        System.out.println("Protected: " + protectedVariable + " - " + protectedMessage);
        protectedMethod();
        
        // Public: Accessible (1)
        System.out.println("Public: " + publicVariable + " - " + PUBLIC_CONSTANT);
        publicMethod();
    }
    
    // Override protected method
    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in subclass");
        super.protectedMethod();
    }
}