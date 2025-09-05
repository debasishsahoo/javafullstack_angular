package com.example;

public class Parent { // Must be public to be accessed from another package
	int defaultField = 100; // default access - NOT inherited outside package
	protected int protectedField = 200; // protected - inherited in subclasses
	public int publicField = 300; // public - inherited anywhere

	void defaultMethod() { // default access - NOT inherited outside package
		System.out.println("Default method");
	}

	protected void protectedMethod() { // protected - can be overridden
		System.out.println("Protected method");
	}

	public void publicMethod() { // public - can be overridden
		System.out.println("Public method");
	}
}