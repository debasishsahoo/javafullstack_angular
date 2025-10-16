package Q10;

public class ReentrantExample {
	private int counter = 0;

	public synchronized void method1() {
		counter++;
		method2(); // Can call another synchronized method
	}

	public synchronized void method2() {
		counter++;
		// Thread already holds the lock, so it can enter
	}

	public synchronized void recursive(int n) {
		if (n > 0) {
			counter++;
			recursive(n - 1); // Reentrant call
		}
	}

	public static void main(String[] args) {
		ReentrantExample obj = new ReentrantExample();
		obj.method1(); // Works fine
		obj.recursive(5); // Works fine
		System.out.println("Counter: " + obj.counter); // 7
	}
}
