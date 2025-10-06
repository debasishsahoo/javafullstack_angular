package debugCode.Q4;

public class Derived extends Base {
	public static void staticMethod() {
        System.out.println("Derived static method");
    }

    @Override
    public void instanceMethod() {
        System.out.println("Derived instance method");
    }
}
