package InheritanceLimitations;

class Bird {
	void fly() {
		System.out.println("Flying");
	}
}

class Fish {
	void swim() {
		System.out.println("Swimming");
	}
}

//We can't create a class that inherits from both Bird and Fish
//class FlyingFish extends Bird, Fish { } // ❌ NOT ALLOWED

//Workaround using interfaces
interface Flying {
	default void fly() {
		System.out.println("Flying");
	}
}

interface Swimming {
	default void swim() {
		System.out.println("Swimming");
	}
}

class FlyingFish implements Flying, Swimming { // ✅ ALLOWED
	// Can use default implementations or override them
}

public class Rule2 {

}
