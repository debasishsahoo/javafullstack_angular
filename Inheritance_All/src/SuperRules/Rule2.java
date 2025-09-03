package SuperRules;

//Rule 2: Cannot use super to access private members of the parent class
class Parent2 {
    private String secret = "Parent's secret";
    protected String info = "Parent's info";
}

class Child2 extends Parent2 {
	void accessMembers() {
		System.out.println(super.secret); // Error: private member
		System.out.println("Accessing parent's protected member: " + super.info); // OK
	}
}


public class Rule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
