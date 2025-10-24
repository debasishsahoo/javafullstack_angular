package com.java.Iterator;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeExample {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("AWS");
		list.add("Azure");
		list.add("GCP");

		Iterator<String> itr = list.iterator();
		System.out.println("Fail-Safe Iterator Example:");

		while (itr.hasNext()) {
			System.out.println(itr.next());
			// Safe to modify during iteration
			list.add("DevOps");
		}

		System.out.println("Final List: " + list);

	}

}
