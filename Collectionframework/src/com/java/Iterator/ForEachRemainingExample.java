package com.java.Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachRemainingExample {

	public static void main(String[] args) {
		List<String> courses = Arrays.asList("Java", "Python", "AWS", "DevOps");

		Iterator<String> itr = courses.iterator();

		itr.forEachRemaining(course -> System.out.println("Course: " + course));

	}

}
