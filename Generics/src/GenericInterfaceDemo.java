
interface MinMax<T extends Comparable<T>> {
	T min();
	T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
	private T[] vals;

	MyClass(T[] vals) {
		this.vals = vals;
	}

	public T min() {
		T min = vals[0];
		for (T val : vals)
			if (val.compareTo(min) < 0)
				min = val;
		return min;
	}

	public T max() {
		T max = vals[0];
		for (T val : vals)
			if (val.compareTo(max) > 0)
				max = val;
		return max;
	}
}

public class GenericInterfaceDemo {
	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 3, 4, 5 };
		MyClass<Integer> obj = new MyClass<>(nums);
		System.out.println("Min: " + obj.min());
		System.out.println("Max: " + obj.max());
	}

}
