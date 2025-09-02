package inheritance_1;

public class Main {
	 public static void main(String[] args) {
		 Dog dog = new Dog();
		 dog.eat();  // Inherited from Animal
	     dog.bark(); // Defined in Dog
	 }
}
//Dog inherits all accessible members from Animal, 
//so a Dog object can use both the eat() method and the "name" field, 
//plus its own bark() method.