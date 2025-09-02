package Multilevel_Inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		dog.eat(); // From Animal
		dog.walk(); // From Mammal
		dog.bark(); // From Dog
	}
}
