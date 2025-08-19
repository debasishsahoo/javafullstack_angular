public class Person {
	String name;
	int age;
	void greet() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

	public static void main(String[] args) {
		// Creating two different objects
		Person p1 = new Person();
        Person p2 = new Person();
        
        // Assign values to individual objects
        p1.name = "Alice";
        p1.age = 25;
        
        p2.name = "Bob";
        p2.age = 30;
        
        // Print object-specific information
        System.out.println(p1.name + " is " + p1.age + " years old.");
        System.out.println(p2.name + " is " + p2.age + " years old.");
        
        
        
        
        
        //p1 and p2 have individual object information.
        //Even though both are Person objects, their states are independent.
        
        p1.greet();  // Uses p1's state
        p2.greet();  // Uses p2's state
        //Methods are part of the class definition and are shared among all objects.
        //When a method is called, it operates on the state of the specific object that invoked it.
	}
}
