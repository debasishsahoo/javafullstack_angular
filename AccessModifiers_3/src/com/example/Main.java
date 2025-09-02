package com.example;

import com.example.package1.AccessModifierDemo;
import com.example.package1.SamePackageClass;
import com.example.package1.SamePackageSubclass;
import com.example.package2.DifferentPackageSubclass;
import com.example.package2.DifferentPackageClass;

/**
 * Main class to demonstrate all access modifier scenarios
 * Runs tests that correspond to the access modifier table
 */
public class Main {
    
	
    public static void main(String[] args) {
        System.out.println("JAVA ACCESS MODIFIERS DEMONSTRATION");
        System.out.println("===================================");
        System.out.println("Table Pattern: [Private, Package, Protected, Public]");
        System.out.println("Same Class:              [1, 1, 1, 1]");
        System.out.println("Same Package:            [0, 1, 1, 1]");
        System.out.println("Subclass (Diff Package): [0, 0, 1, 1]");
        System.out.println("Other Package:           [0, 0, 0, 1]");
        System.out.println("===================================\n");
        
        // 1. Test same class access (1,1,1,1)
        AccessModifierDemo demo = new AccessModifierDemo();
        demo.demonstrateSameClassAccess();
        
        // 2. Test same package class access (0,1,1,1)
        SamePackageClass samePackageClass = new SamePackageClass();
        samePackageClass.testAccess();
        
        // 3. Test same package subclass access (0,1,1,1)
        SamePackageSubclass samePackageSubclass = new SamePackageSubclass();
        samePackageSubclass.testInheritedAccess();
        
        // 4. Test different package subclass access (0,0,1,1)
        DifferentPackageSubclass diffPackageSubclass = new DifferentPackageSubclass();
        diffPackageSubclass.testInheritedAccess();
        diffPackageSubclass.modifyProtectedMembers();
        
        // 5. Test different package regular class access (0,0,0,1)
        DifferentPackageClass diffPackageClass = new DifferentPackageClass();
        diffPackageClass.testAccess();
        
        System.out.println("\n=== SUMMARY ===");
        printAccessModifierSummary();
    }
    
    private static void printAccessModifierSummary() {
        System.out.println("Access Modifier Rules:");
        System.out.println("• private:           Same class only");
        System.out.println("• package-private:   Same package only");  
        System.out.println("• protected:         Same package + subclasses (any package)");
        System.out.println("• public:            Accessible everywhere");
        System.out.println("\nKey Points:");
        System.out.println("• Private members are NEVER inherited");
        System.out.println("• Protected allows subclass access across packages");
        System.out.println("• Package-private restricts access to same package only");
        System.out.println("• Public has no access restrictions");
    }
}
