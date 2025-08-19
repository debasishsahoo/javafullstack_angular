package StaticVsInstance;

public class Person {
	String name;       // instance variable
	int age;          // instance variable
    static String species="Human"; // static variable and set static data

    void showInfo1() {
    	System.out.println(name + " is " + age + " years old.");
    }
    void showInfo2() {
    	System.out.println(name + " is a " + species);
    }
}

//species is shared among all objects; changing it affects all instances.