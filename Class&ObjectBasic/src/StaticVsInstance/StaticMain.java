package StaticVsInstance;

public class StaticMain {
	public static void main(String[] args) {
		Person p1 = new Person();
        p1.name = "Alice";
        p1.age = 25;

        Person p2 = new Person();
        p2.name = "Bob";
        p2.age = 30;

        p1.showInfo1(); // Alice is 25 years old.
        p2.showInfo1(); // Bob is 30 years old.
        
        p1.showInfo2(); // Alice is a Human
        p2.showInfo2(); // Bob is a Human
        
        // Changing static variable
        Person.species = "Homosapiens";//Update Static Variable
        p1.showInfo2(); // Alice is a Homosapiens
        p2.showInfo2(); // Bob is a Homosapiens
	}
}
