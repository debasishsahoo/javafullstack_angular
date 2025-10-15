package Thread;

class MyThread1 extends Thread {
	public void run() {
		// This code runs in a separate thread
		System.out.println("Thread running...");
	}
}

public class ThraedExample1 {

	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
        t.start();

	}

}
