package com.example.package2;

import com.example.package1.AccessModifierDemo;

/**
 * Regular class in a different package from AccessModifierDemo
 * Demonstrates access pattern: 0,0,0,1 (only public accessible)
 */
public class DifferentPackageClass {
    
    public void testAccess() {
        System.out.println("\n=== Access from Different Package Class (0,0,0,1) ===");
        AccessModifierDemo demo = new AccessModifierDemo();
        
        // Private: NOT accessible (0)
        // System.out.println(demo.privateVariable); // ✗ Compilation error
        System.out.println("Private: Not accessible - using public getter: " + demo.getPrivateVariable());
        
        // Package-private: NOT accessible from different package (0)
        // System.out.println(demo.packagePrivateVariable); // ✗ Compilation error
        // demo.packagePrivateMethod(); // ✗ Compilation error
        System.out.println("Package-private: Not accessible from different package");
        
        // Protected: NOT accessible from non-subclass in different package (0)
        // System.out.println(demo.protectedVariable); // ✗ Compilation error
        // demo.protectedMethod(); // ✗ Compilation error
        System.out.println("Protected: Not accessible from non-subclass in different package");
        
        // Public: Accessible (1)
        System.out.println("Public: " + demo.publicVariable + " - " + AccessModifierDemo.PUBLIC_CONSTANT);
        demo.publicMethod();
    }
}