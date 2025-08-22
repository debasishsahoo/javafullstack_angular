//Access modifiers in Java are keywords(public,private,protected)
//work:control the visibility and accessibility
//to whom:classes,methods,variables,constructors,Package,Subclass
//determine which parts of your code can access specific members 
//from different locations in your program
package com.example.package2;


public class PublicClass {
	public String publicField = "I am public";
	public static int publicStaticField = 100;

	// Public constructor
	public PublicClass() {
		System.out.println("Public constructor called");
	}

	// Public method
	public void publicMethod() {
		System.out.println("This is a public method");
	}

	// Public static method
	public static void publicStaticMethod() {
		System.out.println("This is a public static method");
	}
}
