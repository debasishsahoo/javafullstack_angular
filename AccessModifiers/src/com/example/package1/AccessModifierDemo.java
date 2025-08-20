package com.example.package1;

public class AccessModifierDemo {

	// All types of access modifiers for fields
	public String publicField = "Public Field";
	protected String protectedField = "Protected Field";
	String defaultField = "Default Field";
	private String privateField = "Private Field";
	

	// All types of access modifiers for methods
	public void publicMethod() {
		System.out.println("Public method called");
	}

	protected void protectedMethod() {
		System.out.println("Protected method called");
	}

	void defaultMethod() {
		System.out.println("Default method called");
	}

	private void privateMethod() {
		System.out.println("Private method called");
	}

	
	// Method to show internal access
	public void demonstrateInternalAccess() {
		System.out.println("\n=== Internal Access (Same Class) ===");
		System.out.println("Public: " + publicField);
		System.out.println("Protected: " + protectedField);
		System.out.println("Default: " + defaultField);
		System.out.println("Private: " + privateField);

		publicMethod();
		protectedMethod();
		defaultMethod();
		privateMethod();
	}

	// Static method with different access modifiers
	public static void publicStaticMethod() {
		System.out.println("Public static method");
	}

	protected static void protectedStaticMethod() {
		System.out.println("Protected static method");
	}

	static void defaultStaticMethod() {
		System.out.println("Default static method");
	}

	private static void privateStaticMethod() {
		System.out.println("Private static method");
	}

}
