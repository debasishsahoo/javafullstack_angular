package constructorchaining;
class GrandParent {
    public GrandParent() {
        System.out.println("1. GrandParent constructor");
    }
}
class Parent extends GrandParent {
    public Parent() {
        System.out.println("2. Parent constructor");
    }
}
class Child extends Parent {
    public Child() {
        System.out.println("3. Child constructor");
    }
}
public class ImplicitConstructorChaining {
	public static void main(String[] args) {
		 // Creating object of Child
		Child obj = new Child();
	}
}
//Java automatically calls the constructor chain:
//1. `GrandParent()` runs first (topmost).
//2. Then `Parent()` runs.
//3. Finally `Child()` runs.

//**This happens because every constructor**
//**implicitly calls `super()` (unless you explicitly call a different one).**










