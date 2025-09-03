package SuperRules;
//Rule 6: Cannot chain both super() and this() in the same constructor
class Parent6 {
	Parent6() {
		System.out.println("Parent6 no-arg constructor");
	}

	Parent6(String message) {
		System.out.println("Parent6 parameterized constructor: " + message);
	}
}

class Child6 extends Parent6 {
	Child6() {
		//super("Default");
		this("Default"); //call Child6(String message);
		System.out.println("Child6 no-arg constructor");
	}

	Child6(String message) {
		super(message); // Calls parent constructor
		System.out.println("Child6 parameterized constructor");
	}

}

public class Rule6 {
	public static void main(String[] args) {
		Child6 c6=new Child6();
	}
	
}
