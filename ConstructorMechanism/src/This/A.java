package This;

//4. Pass the current object as an argument
public class A {
	void display(B obj) {
		System.out.println("Method called using this");
	}

	void call() {
		B b = new B(this); // passing current object(Obj of A Class)
	}
}
