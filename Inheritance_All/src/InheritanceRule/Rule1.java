package InheritanceRule;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Mammal {
    void breathe() {
        System.out.println("Mammal is breathing");
    }
}
//This will cause a compilation error - can't extend multiple classes
class Dog extends Animal, Mammal { }  // ❌ NOT ALLOWED

//This is valid - single inheritance
public class Rule1 extends Animal{ // ✅ ALLOWED
	void bark() {
        System.out.println("Dog is barking");
    }

}
