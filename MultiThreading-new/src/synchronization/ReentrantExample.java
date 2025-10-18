package synchronization;

//A thread can acquire the same lock multiple times then its call Reentrant Synchronization

public class ReentrantExample {
	private int counter = 0;

	public synchronized void method1() {
		counter++;
		System.out.println("Counter from m1: " + counter);
		method2(); // Can call another synchronized method
	}

	public synchronized void method2() {
		counter++;
		System.out.println("Counter from m2: " + counter);
		// Thread already holds the lock, so it can enter
	}

	public synchronized void recursive(int n) {
		if (n > 0) {
			counter++;
			System.out.println("Counter from m3: " + counter);
			recursive(n - 1); // Reentrant call
		}
	}

	public static void main(String[] args) {
		ReentrantExample obj = new ReentrantExample();
		obj.method1(); // Works fine
		
		obj.recursive(8); // Works fine
		
		System.out.println("Counter from OBJ: " + obj.counter); // 10
	}

	
//	method1() called:
//	    lock acquired
//	    counter = 1
//	    method2() called:
//	        lock already held → enters
//	        counter = 2
//	    lock released after method1() completes
//
//	recursive(5) called:
//	    lock acquired
//	    counter increments 5 times
//	    lock released after recursive call completes

	
	
	//Synchronized Blocks vs Methods IMP
	
	
	
	
}
