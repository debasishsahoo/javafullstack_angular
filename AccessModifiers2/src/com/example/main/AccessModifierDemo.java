package com.example.main;

import com.example.original.BaseClass;
import com.example.original.SamePackageClass;
public class AccessModifierDemo {
	public static void main(String[] args) {
		System.out.println("Java Access Modifier Demonstration");
        System.out.println("====================================");
        
        // Create instances and test access
        BaseClass base = new BaseClass();
        
        // Test same package access
        SamePackageClass samePackage = new SamePackageClass();
        samePackage.testAccess();
	}
}
