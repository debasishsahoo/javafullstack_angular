package com.java.collection.list.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorCombinedDemo {

	public static void main(String[] args) {
		// 1. Creating a Vector (default capacity 10)
		Vector<Object> vector = new Vector<>();

		// 2. Adding heterogeneous elements
		vector.add(10); // Integer
		vector.add("Java"); // String
		vector.add(20.5); // Double
		vector.add(null); // Null element
		vector.add("Java"); // Duplicate

		System.out.println("Initial Vector: " + vector);

		// 3. Access elements by index (insertion order preserved)
		System.out.println("Element at index 1: " + vector.get(1));

		// 4. Demonstrate resizing (adding more elements to exceed default capacity)
		for (int i = 0; i < 10; i++)
			vector.add(i);
		System.out.println("After adding more elements: " + vector);
		System.out.println("Vector capacity after growth: " + vector.capacity());

		// 5. Iterating using Enumeration (Legacy)
		System.out.println("\nIterating using Enumeration:");
		
		Enumeration<Object> e = vector.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		
		// 6. Iterating using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<Object> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 7. Iterating using ListIterator
        System.out.println("\nIterating using ListIterator (forward):");
        ListIterator<Object> listIt = vector.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }
		
		
     // 8. Demonstrate thread-safe addition (simple example)
        Thread t1 = new Thread(() -> {
            synchronized (vector) {
                vector.add("Thread-1");
                System.out.println("Thread-1 added element");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (vector) {
                vector.add("Thread-2");
                System.out.println("Thread-2 added element");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
		
		
        // 9. Final Vector after multithreaded additions
        System.out.println("\nFinal Vector (after threads): " + vector);
		
        // 10. Demonstrate clone() and capacity
        Vector<Object> clonedVector = (Vector<Object>) vector.clone();
        System.out.println("\nCloned Vector: " + clonedVector);
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        // 11. Clearing Vector
        vector.clear();
        System.out.println("Vector after clearing: " + vector);
		
		
		
		
		
		
		
		
		
		

	}

}
