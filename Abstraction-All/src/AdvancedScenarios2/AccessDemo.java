package AdvancedScenarios2;

public abstract class AccessDemo {
	// Public abstract method - can be accessed anywhere
	public abstract void publicMethod();

	// Protected abstract method - accessible in subclasses and same package
	protected abstract void protectedMethod();

	// Default (package-private) abstract method
	abstract void defaultMethod();
	
	// Private abstract method is NOT ALLOWED
    // private abstract void privateMethod(); // COMPILE ERROR
    
    // Static abstract method is NOT ALLOWED
    // static abstract void staticMethod(); // COMPILE ERROR
    
    // Final abstract method is NOT ALLOWED (contradiction)
    // final abstract void finalMethod(); // COMPILE ERROR
}
