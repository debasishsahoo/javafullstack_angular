package com.java.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("AWS");
		list.add("Azure");
		list.add("GCP");

		Iterator<String> itr = list.iterator();
		System.out.println("Fail-Fast Iterator Example:");

		while (itr.hasNext()) {
			System.out.println(itr.next());
			// Structural modification during iteration
			list.add("DevOps"); // Causes ConcurrentModificationException
		}

	}

}
