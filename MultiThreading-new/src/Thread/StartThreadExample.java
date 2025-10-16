package Thread;
//How to Start a Thread in Java
//creating a thread object is not enough-you must call the start() method to begin 
//When Start() Call
//Moves the thread from the NEW state to the RUNNABLE state
//Allocates system resources for the thread
//Eventually, the thread scheduler picks it to run, executing the run() method in a separate call stack.
public class StartThreadExample {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": Thread is running");
        }, "MyThread");


	}

}
