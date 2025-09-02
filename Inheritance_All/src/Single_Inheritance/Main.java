package Single_Inheritance;

public class Main {
	 public static void main(String[] args) {
		 Dog dog = new Dog();
		 dog.eat();  // Inherited from Animal
	     dog.bark(); // Defined in Dog
	 }
}
//Single Inheritance:
//Dog inherits all accessible members from Animal, 
//so a Dog object can use both the eat() method and the "name" field, 
//plus its own bark() method.

//Features
//Code Re-usability:
//Method Overriding:
//super Keyword:
//Constructor Chaining:

//Access Modifiers:
//private members are not inherited.
//protected and public members are fully accessible.
//Default (package-private) members are accessible only within the same package.





