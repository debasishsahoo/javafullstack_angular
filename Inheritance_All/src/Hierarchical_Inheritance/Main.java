package Hierarchical_Inheritance;

public class Main {

	public static void main(String[] args) {
		 Dog dog = new Dog();
		 dog.eat();  // Inherited from Animal
	     dog.bark(); // Own method
	     
	     Cat cat = new Cat();
	     cat.eat();  // Inherited from Animal
	     cat.meow(); // Own method
	}

}
