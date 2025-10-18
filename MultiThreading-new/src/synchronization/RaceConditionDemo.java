//preventing race conditions and ensuring thread safety
//It allows only one thread at a time to execute a particular block of code or method
package synchronization;

//counter++ is not atomic: it involves read, increment, and write steps.
//Two threads may read the same value simultaneously, leading to lost increments.

//The final value of counter is unpredictable and usually less than the expected 200,000


public class RaceConditionDemo {
	// Shared variable accessed by multiple threads
	//increments of Counter
		//Read the current value  
		//Increment it            
		//Write it back        
	
	//When threads interleave these steps, updates get lost
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {

		// Thread 1 increments counter 100,000 times
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100_000; i++) {
				counter++; // Not atomic!
			}
		}, "Thread-1");
		// Thread 2 increments counter 100,000 times
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100_000; i++) {
				counter++; // Not atomic!
			}
		}, "Thread-2");

		// Start threads
		t1.start();
		t2.start();

		// Wait for threads to finish
		t1.join();
		t2.join();

		System.out.println("Expected: 200000");
		System.out.println("Actual: " + counter);

	}

}
