package Q1;

//Method 1: Extending Thread class
class MyThread extends Thread {
	public void run() {
		System.out.println("Thread running using Thread class");
	}
}

//Method 2: Implementing Runnable interface
class MyRunnable implements Runnable {
	public void run() {
		System.out.println("Thread running using Runnable interface");
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		// --- Method 1: Using Thread subclass ---
		MyThread t1 = new MyThread();
		t1.start(); // start() calls run() internally in a separate thread

		// --- Method 2: Using Runnable implementation ---
		MyRunnable myRunnable = new MyRunnable();
		Thread t2 = new Thread(myRunnable);
		t2.start(); // start a new thread for Runnable object

		// --- Main thread message ---
		System.out.println("Main thread running...");

	}

}
