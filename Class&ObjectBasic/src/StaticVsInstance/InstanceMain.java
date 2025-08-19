package StaticVsInstance;
//Instance Data (Object-level data)
//Instance data belongs to each object of a class. 
//Every object has its own copy of these variables.
//Stored in heap memory as part of the object.
//Accessed through the object reference.
//Changing instance data in one object does not affect other objects.
public class InstanceMain {
	public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Alice";
        p1.age = 25;

        Person p2 = new Person();
        p2.name = "Bob";
        p2.age = 30;

        p1.showInfo1(); // Alice is 25 years old.
        p2.showInfo1(); // Bob is 30 years old.
    }
}
//Each object has its own copy of name and age.