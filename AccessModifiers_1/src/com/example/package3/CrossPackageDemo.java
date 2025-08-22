package com.example.package3;

import com.example.package2.PublicClass;
import com.example.package1.AccessModifierDemo;

public class CrossPackageDemo extends AccessModifierDemo {
	public void demonstrateCrossPackageAccess() {
		System.out.println("\n=== Cross Package Access Demo ===");

		// Creating object of public class from different package
		PublicClass publicObj = new PublicClass();
		System.out.println("Public field: " + publicObj.publicField);
		publicObj.publicMethod();
		PublicClass.publicStaticMethod();

		// Accessing inherited members
		System.out.println("Public inherited: " + publicField);
		System.out.println("Protected inherited: " + protectedField);

		// CANNOT access default members from different package
		// System.out.println("Default: " + defaultField); // Compilation error
		// CANNOT access private members
		// System.out.println("Private: " + privateField); // Compilation error

		publicMethod();

		protectedMethod(); // Can access through inheritance

		// defaultMethod(); // Compilation error
		// privateMethod(); // Compilation error
	}

}
