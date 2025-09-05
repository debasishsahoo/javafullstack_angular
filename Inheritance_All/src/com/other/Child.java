package com.other;

import com.example.Parent;

public class Child extends Parent {
    public void accessParentMembers() {
        // ❌ Default members are NOT inherited from a different package
         System.out.println(defaultField);  // Compilation error
         defaultMethod();                   // Compilation error
        
        // ✅ Protected and public members are inherited
        System.out.println(protectedField);   // Accessible
        System.out.println(publicField);      // Accessible
        
        protectedMethod();                    // Accessible
        publicMethod();                       // Accessible
    }
    
    // ❌ Cannot override default methods from different package
     void defaultMethod() { }  // This would be a new method, not an override
    
    // ✅ Can override protected/public methods
    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method");
    }
    
    @Override
    public void publicMethod() {
        System.out.println("Overridden public method");
    }
}

//Default (package-private): Not accessible outside the package.
//Default methods cannot be overridden outside the package, they not visible outside their package.
//When you define a method with the same name in a subclass in a different package, 
//it’s not overriding; it’s a completely new method.
//package com.other;

import com.example.Parent;

public class Child extends Parent {
    public void accessParentMembers() {
        // ❌ Default members are NOT inherited from a different package
         System.out.println(defaultField);  // Compilation error
         defaultMethod();                   // Compilation error
        
        // ✅ Protected and public members are inherited
        System.out.println(protectedField);   // Accessible
        System.out.println(publicField);      // Accessible
        
        protectedMethod();                    // Accessible
        publicMethod();                       // Accessible
    }
    
    // ❌ Cannot override default methods from different package
     void defaultMethod() { }  // This would be a new method, not an override
    
    // ✅ Can override protected/public methods
    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method");
    }
    
    @Override
    public void publicMethod() {
        System.out.println("Overridden public method");
    }
}

//Default (package-private): Not accessible outside the package.
//Default methods cannot be overridden outside the package, they not visible outside their package.
//When you define a method with the same name in a subclass in a different package, 
//it’s not overriding; it’s a completely new method.
//There is no way to call the parent's default method from a subclass in a different package.





































