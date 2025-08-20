package com.example.other;
import com.example.original.BaseClass;
public class OtherPackageClass {
	 public void testAccess() {
	        System.out.println("\\n=== Other Package (Non-subclass) Access ===");
	        BaseClass obj = new BaseClass();
	        
	        // Only public accessible
	        System.out.println("Public: " + obj.publicField);
	        System.out.println("Protected: " + obj.protectedField);  // Compilation Error
	        // System.out.println("Default: " + obj.defaultField);      // Compilation Error  
	        // System.out.println("Private: " + obj.privateField);      // Compilation Error
	        
	        obj.publicMethod();
	        obj.protectedMethod();  // Compilation Error
	        // obj.defaultMethod();    // Compilation Error
	        // obj.privateMethod();    // Compilation Error
	    }
}
