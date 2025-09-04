package InheritanceRule;

class Parent {
    private String secret = "Parent's secret"; // Private field
    protected String knowledge = "Parent's knowledge"; // Protected field

    private void privateMethod() {
        System.out.println("Private method");
    }

    protected void protectedMethod() {
        System.out.println("Protected method");
    }
}



class Child extends Parent {
	
	void accessMembers() {
		System.out.println(secret);    //// ❌ ERROR: private field not accessible
		System.out.println(knowledge); //// ✅ OK: protected field is accessible
		
		privateMethod(); // ❌ ERROR: private method not accessible
        protectedMethod(); // ✅ OK: protected method is accessible
		
		
	}
	
}








public class Rule4_5 {

}
