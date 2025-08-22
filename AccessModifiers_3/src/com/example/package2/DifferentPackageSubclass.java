package com.example.package2;

import com.example.package1.AccessModifierDemo;

/**
 * Subclass in a different package from AccessModifierDemo
 * Demonstrates access pattern: 0,0,1,1 (only protected and public accessible)
 */
public class DifferentPackageSubclass extends AccessModifierDemo {
    
    public DifferentPackageSubclass() {
        super();
        System.out.println("DifferentPackageSubclass constructor called");
    }
    
    public void testInheritedAccess() {
        System.out.println("\n=== Access from Different Package Subclass (0,0,1,1) ===");
        
        // Private: NOT accessible (0)
        // System.out.println(privateVariable); // ✗ Compilation error
        System.out.println("Private: Not accessible - using inherited getter: " + getPrivateVariable());
        
        // Package-private: NOT accessible from different package (0)
        // System.out.println(packagePrivateVariable); // ✗ Compilation error
        // packagePrivateMethod(); // ✗ Compilation error
        System.out.println("Package-private: Not accessible from different package");
        
        // Protected: Accessible in subclass (1)
        System.out.println("Protected: " + protectedVariable + " - " + protectedMessage);
        protectedMethod();
        
        // Public: Accessible (1)
        System.out.println("Public: " + publicVariable + " - " + PUBLIC_CONSTANT);
        publicMethod();
    }
    
    // Method to demonstrate protected access
    public void modifyProtectedMembers() {
        // Can modify inherited protected members
        protectedVariable = 100;
        protectedMessage = "Modified by subclass in different package";
    }
}