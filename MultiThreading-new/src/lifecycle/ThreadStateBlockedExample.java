package lifecycle;


//Intrinsic Lock(synchronized)
class SharedResource {
	synchronized void method1() {
		try {
			System.out.println(Thread.currentThread().getName() + " is executing method1");
			Thread.sleep(5000); // hold the lock for 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " is executing method2");
	}
}

public class ThreadStateBlockedExample {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();

		// Thread A acquires the lock first
		Thread t1 = new Thread(() -> resource.method1(), "Thread-A");

		// Thread B tries to access another synchronized method and will be BLOCKED
		Thread t2 = new Thread(() -> resource.method2(), "Thread-B");

		t1.start();
		t2.start();

		try {
			Thread.sleep(100); // give t2 a chance to attempt lock
			System.out.println(t2.getName() + " state: " + t2.getState()); // Should show BLOCKED
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}