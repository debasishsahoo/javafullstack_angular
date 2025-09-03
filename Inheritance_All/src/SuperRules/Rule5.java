package SuperRules;
//Rule 5: If parent doesn't have a no-arg constructor, child must explicitly call super
class Parent5 {	
	Parent5(String name){
		System.out.println("Parent5 constructor with name: ");
	}
}


class Child5 extends Parent5 {
	
	Child5() {
		super("Default Name");
		System.out.println("Child5 constructor");
	}

	Child5(String name) {
		super(name);
		System.out.println("Child5 constructor with name");
	}
}

public class Rule5 {

	public static void main(String[] args) {

	}

}
