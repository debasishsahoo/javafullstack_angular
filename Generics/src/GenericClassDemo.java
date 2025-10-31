//Generic Class

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Box<T> {
	private T value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}

// Generic class with K (Key) and V (Value)
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Pair{" + key + " = " + value + "}";
	}
}

//Generic method using N (Number)
class MathUtil {
	public static <N extends Number> double add(N a, N b) {
		return a.doubleValue() + b.doubleValue();
	}
}

//Generic method using S, U, V (multiple types)
class Triple<S, U, V> {
	private S first;
	private U second;
	private V third;

	public Triple(S first, U second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public void display() {
		System.out.println("Triple -> (" + first + ", " + second + ", " + third + ")");
	}
}

public class GenericClassDemo {

	public static void main(String[] args) {
		// Example of T Type (used in generic class)
		Box<Integer> intBox = new Box<>();
		intBox.set(100);
		System.out.println("Integer Value: " + intBox.get());

		Box<String> strBox = new Box<>();
		strBox.set("Hello Generics");
		System.out.println("String Value: " + strBox.get());

		// Example of E - Element (used in collections)
		Collection<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Mango");
		System.out.println("E Example (Collection<E>): " + fruits);

		// K & V - Key and Value (used in Map)
		Map<String, Integer> studentScores = new HashMap<>();
		studentScores.put("Debasish", 95);
		studentScores.put("Sahoo", 90);
		System.out.println("K & V Example (Map<K,V>): " + studentScores);

		// Using Pair class
		Pair<String, Integer> pair = new Pair<>("Age", 25);
		System.out.println("K & V Example (Pair<K,V>): " + pair);

		// 4. N - Number (generic method with Number type)
		double sum1 = MathUtil.add(10, 20); // Integer
		double sum2 = MathUtil.add(10.5, 15.5); // Double
		System.out.println("N Example (MathUtil.add): " + sum1 + ", " + sum2);

		// 5. S, U, V - Multiple type parameters
		Triple<String, Integer, Double> data = new Triple<>("Count", 10, 99.9);
		data.display();

	}

}
