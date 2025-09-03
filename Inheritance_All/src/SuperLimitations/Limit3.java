package SuperLimitations;
//Cannot use super in interface default methods to access Object methods
interface MyInterface {
	default void myMethod() {
		//System.out.println(super.toString()); //// Error: no enclosing instance
		System.out.println("Interface default method");
	}
}

class MyClass implements MyInterface {
	// Can override the default method
	@Override
	public void myMethod() {
		MyInterface.super.myMethod();//// Valid syntax for interface default methods
		System.out.println("Class implementation");
	}
}

public class Limit3 {

}
