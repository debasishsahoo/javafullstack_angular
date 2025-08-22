package com.example.other;

import com.example.original.BaseClass;
public class SubclassInOtherPackage extends BaseClass {
	
//public class SubclassInOtherPackage{
	 public void testAccess() {
	        System.out.println("\\n=== Subclass (Different Package) Access ===");
	        
	        // Accessible: public, protected only
	        System.out.println("Public: " + this.publicField);
	        System.out.println("Protected: " + this.protectedField);
	        // System.out.println("Default: " + this.defaultField);  // Compilation Error
	        // System.out.println("Private: " + this.privateField);  // Compilation Error
	        
	        this.publicMethod();
	        this.protectedMethod();
	        // this.defaultMethod();  // Compilation Error
	        // this.privateMethod();  // Compilation Error
	    }
}
