package com.java.Iterator;

import java.util.*;

class Employees implements Iterable<String> {
	private List<String> empList = new ArrayList<>();

	public Employees() {
		empList.add("Alice");
		empList.add("Bob");
		empList.add("Charlie");
	}

	@Override
	public Iterator<String> iterator() {
		return empList.iterator();
	}
}

public class CustomIterableExample {

	public static void main(String[] args) {
		Employees employees = new Employees();

		for (String emp : employees) {
			System.out.println(emp);
		}

	}

}
