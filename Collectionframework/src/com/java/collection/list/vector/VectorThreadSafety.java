package com.java.collection.list.vector;

import java.util.ArrayList;
import java.util.Vector;

public class VectorThreadSafety {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Vector Thread Safety ===\n");

		// Vector is synchronized - thread-safe
		Vector<Integer> vector = new Vector<>();

		// Create multiple threads that add elements
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				vector.add(i);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 1000; i < 2000; i++) {
				vector.add(i);
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 2000; i < 3000; i++) {
				vector.add(i);
			}
		});

		System.out.println("Starting 3 threads to add 1000 elements each...");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("Final size of Vector: " + vector.size());
		System.out.println("Expected size: 3000");
		System.out.println("Thread-safe: " + (vector.size() == 3000));

		// Compare with ArrayList (not thread-safe)
		System.out.println("\n--- Comparing with ArrayList (not thread-safe) ---");
		ArrayList<Integer> arrayList = new ArrayList<>();

		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				arrayList.add(i);
			}
		});

		Thread t5 = new Thread(() -> {
			for (int i = 1000; i < 2000; i++) {
				arrayList.add(i);
			}
		});

		Thread t6 = new Thread(() -> {
			for (int i = 2000; i < 3000; i++) {
				arrayList.add(i);
			}
		});

		System.out.println("Starting 3 threads with ArrayList...");

		t4.start();
		t5.start();
		t6.start();

		t4.join();
		t5.join();
		t6.join();

		System.out.println("Final size of ArrayList: " + arrayList.size());
		System.out.println("Expected size: 3000");
		System.out.println("May have issues due to lack of synchronization");
	}
}
