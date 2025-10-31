class Parent<T> {
	T value;
}

class Child<T, U> extends Parent<T> {
	U secondValue;
}

public class GenericInheritanceDemo {

	public static void main(String[] args) {
		Child<Integer, String> obj = new Child<>();
		obj.value = 10;
		obj.secondValue = "Hello";
		System.out.println(obj.value + " - " + obj.secondValue);
	}

}
