package com.example.package1;

import com.example.package2.*;

public class AccessModifierMain {
	public static void main(String[] args) {
		System.out.println("=== ACCESS MODIFIERS DEMONSTRATION ===\n");

		// 1. Public access demonstration
		System.out.println("1. PUBLIC ACCESS:");
		PublicClass publicObj = new PublicClass();
		System.out.println(publicObj.publicField);
		publicObj.publicMethod();
		PublicClass.publicStaticMethod();

		// 2. Protected access demonstration (same package)
		System.out.println("\n2. PROTECTED ACCESS (Same Package):");
		ProtectedParent protectedObj = new ProtectedParent();
		protectedObj.accessProtectedMembers();

		ProtectedSamePackage samePackageObj = new ProtectedSamePackage();
		samePackageObj.accessProtected();

		// 3. Default access demonstration
		System.out.println("\n3. DEFAULT ACCESS (Package-Private):");
		DefaultClass defaultObj = new DefaultClass();
		defaultObj.accessDefaultMembers();

		DefaultAccessor defaultAccessor = new DefaultAccessor();
		defaultAccessor.accessDefaultMembers();

		// 4. Private access demonstration
		System.out.println("\n4. PRIVATE ACCESS:");
		PrivateExample privateObj = new PrivateExample();
		privateObj.accessPrivateMembers();
		System.out.println("Getting private field via getter: " + privateObj.getPrivateField());
		PrivateExample.accessPrivateStaticMembers();

		// 5. Comprehensive demonstration
		System.out.println("\n5. COMPREHENSIVE ACCESS:");
		AccessModifierDemo demo = new AccessModifierDemo();
		demo.demonstrateInternalAccess();

		// 6. Inheritance demonstration
		Child child = new Child();
		child.demonstrateInheritanceAccess();

		// 7. Nested classes demonstration
		System.out.println("\n7. NESTED CLASSES:");
		NestedClassDemo nestedDemo = new NestedClassDemo();
		nestedDemo.demonstrateNestedAccess();

		// Static nested class
		NestedClassDemo.StaticNestedClass staticNested = new NestedClassDemo.StaticNestedClass();
		staticNested.staticNestedMethod();

		System.out.println("\n=== END OF DEMONSTRATION ===");

	}
}
