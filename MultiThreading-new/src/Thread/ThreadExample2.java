package Thread;

//A Thread in Java is a lightweight sub-process
//the smallest unit of execution within a program
//It allows a program to perform multiple tasks at the same time (called multithreading).
//concurrently(in parallel)
//A Thread is a separate path of execution in a Java program that runs 
//concurrently (in parallel) with other threads.

class MyThread2 extends Thread {
	//Thread A class in Java (java.lang.Thread) used to create threads
	public void run() {
		//Code inside run() method is executed when the thread starts
		
		// This code runs in a separate thread
		for (int i = 1; i <= 5; i++) {
			//Returns the currently running thread
			System.out.println(Thread.currentThread().getName() + " - Count: " + i);
		}
	}
}

public class ThreadExample2 {

	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2(); // Create first thread
		MyThread2 t2 = new MyThread2(); // Create second thread

		//Starts the thread and internally calls run() in a new thread of execution
		t1.start(); // Start first thread
		t2.start(); // Start second thread

		System.out.println("Main thread running...");
	}

}
