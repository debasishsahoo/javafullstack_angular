package com.example.main;

import com.example.original.BaseClass;
import com.example.original.SamePackageClass;
import com.example.original.SubclassSamePackage;
import com.example.other.SubclassDifferentPackage;
import com.example.other.OtherPackageClass;

public class AccessModifierDemo {
    public static void main(String[] args) {
        System.out.println("JAVA ACCESS MODIFIER DEMONSTRATION");
        System.out.println("=====================================");
        
        // Same class access (via constructor Call)
        //BaseClass base = new BaseClass();
        
        // Same package access
        //SamePackageClass samePackage = new SamePackageClass();
        //samePackage.testAccess();
        
        
        // Subclass same package access
        //SubclassSamePackage subclassSame = new SubclassSamePackage();
        //subclassSame.testAccess();
//        
//        // Subclass different package access
//        SubclassDifferentPackage subclassDiff = new SubclassDifferentPackage();
//        subclassDiff.testAccessViaInheritance();
//        subclassDiff.testAccessViaObject();
//        
//        // Other package non-subclass access
//        OtherPackageClass otherPackage = new OtherPackageClass();
//        otherPackage.testAccess();
//        
//        printDetailedAccessTable();
//    }
//    
//    private static void printDetailedAccessTable() {
//        System.out.println("\n" + "=".repeat(80));
//        System.out.println(" FINAL CORRECT ACCESS RULES");
//        System.out.println("=".repeat(80));
//        System.out.println("┌───────────┬───────────┬──────────────┬─────────────────────┬─────────────────────┬─────────────────┐");
//        System.out.println("│ Modifier  │Same Class │ Same Package │Subclass(same pkg)   │Subclass(diff pkg)   │Other pkg(non-sub)│");
//        System.out.println("├───────────┼───────────┼──────────────┼─────────────────────┼─────────────────────┼─────────────────┤");
//        System.out.println("│ public    │     ✓     │      ✓       │          ✓          │          ✓          │        ✓        │");
//        System.out.println("│ protected │     ✓     │      ✓       │          ✓          │✓(via inheritance)   │        ✗        │");
//        System.out.println("│           │           │              │                     │✗(via object)        │                 │");
//        System.out.println("│ default   │     ✓     │      ✓       │          ✓          │          ✗          │        ✗        │");
//        System.out.println("│ private   │     ✓     │      ✗       │          ✗          │          ✗          │        ✗        │");
//        System.out.println("└───────────┴───────────┴──────────────┴─────────────────────┴─────────────────────┴─────────────────┘");
//        
//        System.out.println("\n KEY INSIGHTS:");
//        System.out.println("• protected: Accessible in subclasses via 'this.' but NOT via object reference");
//        System.out.println("• default: Package-private, not accessible across package boundaries");
//        System.out.println("• private: Strictest access, only within the same class");
//        System.out.println("• public: Most permissive, accessible everywhere");
//        
//        System.out.println("\n  CRITICAL DISTINCTION FOR PROTECTED:");
//        System.out.println("• SubclassInDifferentPackage can access: this.protectedField ✓");
//        System.out.println("• SubclassInDifferentPackage CANNOT access: obj.protectedField ✗");
//        System.out.println("• This enforces proper inheritance semantics in Java");
   }
}