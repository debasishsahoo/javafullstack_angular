package InterfaceDemo;

public class Main {

	public static void main(String[] args) {
		// Object Ref(Interface)=new Object(Class) to Achive Polymorphism

		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.sound();
		dog.sleep();

		cat.sound();
		cat.sleep();

	}

}
