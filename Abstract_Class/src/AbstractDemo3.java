

//When you want to share code among related classes.
//When you need to enforce a contract but also allow partial implementation.
//When subclasses share common state (fields/constructors).
//Abstract Class -> "is-a" relationship
//Interface ->Represent a "can-do" relationship

interface Electric {
	void charge();
}

//Abstract class
abstract class Appliance {
	String name;

	Appliance(String name) {
		this.name = name;
	}

	abstract void turnOn();

	void turnOff() {
		System.out.println(name + " is turned off.");
	}
}

//WashingMachine extends Appliance & implements Electric
class WashingMachine extends Appliance implements Electric {
	WashingMachine(String name) {
		super(name);
	}

	void turnOn() {
		System.out.println(name + " is turned on and ready to wash clothes.");
	}

	public void charge() {
		System.out.println(name + " is charging via electricity.");
	}
}

public class AbstractDemo3 {
	public static void main(String[] args) {
		WashingMachine wm = new WashingMachine("Samsung Washer");
		wm.turnOn();
		wm.charge();
		wm.turnOff();
	}
}
