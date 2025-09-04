package InheritanceRule;

class P {
    static void staticMethod() {
        System.out.println("This is Parent's static method");
    }

    void instanceMethod() {
        System.out.println("This is Parent's instance method");
    }
}

class C extends P {
	
	// This hides Parent's staticMethod, doesn't override it
	//@Override
    static void staticMethod() {
        System.out.println("Child's static method");
    }

    @Override
    void instanceMethod() {
        System.out.println("Child's instance method");
    }
	
}

public class Rule10 {
	public static void main(String[] args) {
		
        P p = new C();
        p.staticMethod(); // Calls Parent's version - method hiding
        p.instanceMethod(); // Calls Child's version - method overriding

        C c = new C();
        c.staticMethod(); // Calls Child's version
        
    }
}
