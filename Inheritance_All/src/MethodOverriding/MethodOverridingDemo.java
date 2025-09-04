package MethodOverriding;

//Parent class
class Animal {
	public void makeSound() {
		System.out.println("Animal makes a sound");
	}
}

//Child class Dog
class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Dog barks");
	}
}

//Child class Cat
class Cat extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Cat meows");
	}
}

public class MethodOverridingDemo {
	public static void main(String[] args) {
		// Polymorphism in action
		Animal myAnimal = new Animal(); // Parent reference, Parent object
		Animal myDog = new Dog(); // Parent reference, Child object
		Animal myCat = new Cat(); // Parent reference, Child object

		// Calls respective overridden methods
		myAnimal.makeSound(); // Output: Animal makes a sound
		myDog.makeSound(); // Output: Dog barks
		myCat.makeSound(); // Output: Cat meows

		Animal mAnimal = new Animal(); // Parent reference, Parent object
		Dog mDog = new Dog(); // Parent reference, Parent object
		Animal mCat = new Cat(); // Parent reference, Parent object

		// Calls respective overridden methods
		mAnimal.makeSound(); // Output: Animal makes a sound
		mDog.makeSound(); // Output: Dog barks
		mCat.makeSound(); // Output: Cat meows

	}
}

//- `Dog` and `Cat` **override** the `makeSound()` method from `Animal`.
//- We use **runtime polymorphism** (parent reference → child object).
//- The actual method executed depends on the **object type**, not the reference type.
