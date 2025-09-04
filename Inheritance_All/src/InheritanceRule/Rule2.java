package InheritanceRule;

interface Swimmable {
    void swim(); //Abstract Method
}

interface Walkable {
    void walk();
}

class Duck extends Animal implements Swimmable, Walkable {// ✅ ALLOWED
	@Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
	
	@Override
    public void walk() {
        System.out.println("Duck is walking");
    }
	
	void eat() {
        System.out.println("Duck is eating");
    }
}








public class Rule2 {

	public static void main(String[] args) {
		

	}

}
