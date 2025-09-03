package SuperRules;
//Rule 1: super() must be the first statement in a constructor

class Parent1 {
    Parent1(String message) {
        System.out.println("Parent1 constructor: " + message);
    }
}

//This would cause a compilation error
class Child1 extends Parent1 {
	 Child1(){
		 System.out.println("Child1 constructor"); // Error if placed before super()
		 super("Hello from Child1"); // Must be first statement
	 }
}



public class Rule1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
