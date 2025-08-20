package com.example.package1;

public class ProtectedParent {
	protected String protectedField = "I am protected";
	protected static int protectedStaticField = 200;
	// Protected constructor
	protected ProtectedParent() {
		System.out.println("Protected constructor called");
	}
	// Protected method
	protected void protectedMethod() {
		System.out.println("This is a protected method");
	}
	// Protected static method
	protected static void protectedStaticMethod() {
		System.out.println("This is a protected static method");
	}
	// Method to demonstrate access within same class'
	public void accessProtectedMembers() {
		System.out.println("Accessing from same class: " + protectedField);
		protectedMethod();
		protectedStaticMethod();
	}
}
//out of ProtectedParent
//Child class in same package
class ProtectedChild extends ProtectedParent {
	public void accessProtectedFromChild() {
        // Can access protected members from parent
        System.out.println("Accessing from child: " + protectedField);
        protectedMethod();
        protectedStaticMethod();
    }
}
//Another class in same package (not inheritance)
class ProtectedSamePackage {
 public void accessProtected() {
     ProtectedParent parent = new ProtectedParent();
     // Can access protected members within same package
     System.out.println("Same package access: " + parent.protectedField);
     parent.protectedMethod();
     ProtectedParent.protectedStaticMethod();
 }
}
