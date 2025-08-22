package com.example.package1;

public class NestedClassDemo {
	private String outerPrivate = "Outer Private";
	protected String outerProtected = "Outer Protected";

	
	// Public nested class
	public class PublicInnerClass {
		public void accessOuter() {
			System.out.println("Accessing: " + outerPrivate); // Can access private
			System.out.println("Accessing: " + outerProtected);
		}
	}

	// Private nested class
	private class PrivateInnerClass {
		public void accessOuter() {
			System.out.println("Private inner accessing: " + outerPrivate);
			System.out.println("Private inner accessing:: " + outerProtected);
		}
	}

	// Protected nested class
	protected class ProtectedInnerClass {
		public void accessOuter() {
			System.out.println("Protected inner accessing: " + outerPrivate);
			System.out.println("Protected inner accessing: " + outerProtected);
		}
	}

	// Default nested class
	class DefaultInnerClass {
		public void accessOuter() {
			System.out.println("Default inner accessing: " + outerPrivate);
			System.out.println("Default inner accessing: " + outerProtected);
		}
	}

	
	// Static nested class
    public static class StaticNestedClass {
        public void staticNestedMethod() {
            System.out.println("Static nested class method");
            // Cannot access instance members directly
            // System.out.println(outerPrivate); // Compilation error
        }
    }
    
    public void demonstrateNestedAccess() {
        PublicInnerClass publicInner = new PublicInnerClass();
        publicInner.accessOuter();
        
        PrivateInnerClass privateInner = new PrivateInnerClass();
        privateInner.accessOuter();
    }
}
