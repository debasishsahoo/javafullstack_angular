package AdvancedConcepts1;
//50% Abstraction - Mix of abstract and concrete methods
public abstract class Car extends Vehicle {
	abstract void accelerate();
	abstract void brake();

	void honk() {
		System.out.println("Beep! Beep!");
	}
}
