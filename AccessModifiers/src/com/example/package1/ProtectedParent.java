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
	
}
