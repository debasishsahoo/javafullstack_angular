package SuperLimitations;

//Cannot use super to call static methods
class ParentStaticMethod {
	
    static void staticMethod() {
        System.out.println("Parent static method");
    }

    void instanceMethod() {
        System.out.println("Parent instance method");
    }
}

class ChildStaticMethod extends ParentStaticMethod {
	 void callMethods() {
		 // Static methods should be called using class name, not super
		 // Correct way to call Static Method
		 ParentStaticMethod.staticMethod();
		 

		 
		 super.staticMethod(); // Works but misleading - should use class name
		 super.instanceMethod(); // Correct usage for instance methods
		 
		 
		 
		 
	 }
}





public class Limit2 {

}
