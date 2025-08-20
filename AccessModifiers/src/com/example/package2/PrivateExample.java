package com.example.package2;

public class PrivateExample {
	private String privateField = "I am private";
	private static int privateStaticField = 400;

	// Private constructor
	private PrivateExample(String value) {
		this.privateField = value;
		System.out.println("Private constructor called");
	}

	// Public constructor to create instances
	public PrivateExample() {
		this("Default private value");
	}

	// Private method
	private void privateMethod() {
		System.out.println("This is a private method");
	}

	// Private static method
	private static void privateStaticMethod() {
		System.out.println("This is a private static method");
	}

	// Public method to demonstrate access to private members
	public void accessPrivateMembers() {
		System.out.println("Accessing private field: " + privateField);
		privateMethod();
		privateStaticMethod();
	}

	// Getter for private field (encapsulation)
	public String getPrivateField() {
		return privateField;
	}

	// Setter for private field (encapsulation)
	public void setPrivateField(String value) {
		this.privateField = value;
	}

	// Static method to access private static members
	public static void accessPrivateStaticMembers() {
		System.out.println("Private static field: " + privateStaticField);
		privateStaticMethod();
	}
}
