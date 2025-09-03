package SuperRules;

//Rule 4: super always refers to the immediate parent class only
class Grandparent {
    String message = "Grandparent's message";
    void show() {
        System.out.println("Grandparent's show method");
    }
}
class Parent4 extends Grandparent {
    String message = "Parent's message";
    @Override
    void show() {
        System.out.println("Parent's show method");
    }
}

class Child4 extends Parent4 {
	String message = "Child's message";
	@Override
    void show() {
        System.out.println("Child's show method");
    }
	
	void demonstrate() {
		 System.out.println("Current message: " + message);
		 System.out.println("Parent's message: " + super.message);  // Immediate parent only
		 show();
		 super.show(); // Immediate parent's method only
	}
}



public class Rule4 {

}
