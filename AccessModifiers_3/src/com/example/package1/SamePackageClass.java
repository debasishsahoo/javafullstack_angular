package com.example.package1;

/**
 * Class in the same package as AccessModifierDemo
 * Demonstrates access pattern: 0,1,1,1 (can't access private)
 */
public class SamePackageClass {
    
    public void testAccess() {
        System.out.println("\n=== Access from Same Package Class (0,1,1,1) ===");
        AccessModifierDemo demo = new AccessModifierDemo();
        
        // Private: NOT accessible (0)
        // System.out.println(demo.privateVariable); // ✗ Compilation error
        // demo.privateMethod(); // ✗ Compilation error
        System.out.println("Private: Not accessible - using getter: " + demo.getPrivateVariable());
        
        // Package-private: Accessible (1)
        System.out.println("Package: " + demo.packagePrivateVariable + " - " + demo.packagePrivateMessage);
        demo.packagePrivateMethod();
        
        // Protected: Accessible (1)
        System.out.println("Protected: " + demo.protectedVariable + " - " + demo.protectedMessage);
        demo.protectedMethod();
        
        // Public: Accessible (1)
        System.out.println("Public: " + demo.publicVariable + " - " + AccessModifierDemo.PUBLIC_CONSTANT);
        demo.publicMethod();
    }
}