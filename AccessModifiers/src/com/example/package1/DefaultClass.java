package com.example.package1;

//Default class (no access modifier)
// DEFAULT is PACKAGE PRIVATE Access MODIFIER
class DefaultClass {
	String defaultField = "I am default/package-private";
    static int defaultStaticField = 300;
    
    // Default constructor
    DefaultClass() {
        System.out.println("Default constructor called");
    }
    
    // Default method
    void defaultMethod() {
        System.out.println("This is a default method");
    }
    
    // Default static method
    static void defaultStaticMethod() {
        System.out.println("This is a default static method");
    }
    
    // Method to demonstrate access within same class
    public void accessDefaultMembers() {
        System.out.println("Accessing from same class: " + defaultField);
        defaultMethod();
        defaultStaticMethod();
    }
}


//Another class in same package can access default members
class DefaultAccessor {
 public void accessDefaultMembers() {
     DefaultClass obj = new DefaultClass();
     System.out.println("Same package access: " + obj.defaultField);
     obj.defaultMethod();
     DefaultClass.defaultStaticMethod();
 }
}