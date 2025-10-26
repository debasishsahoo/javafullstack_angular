package com.java.collection.list.vector;

import java.util.Vector;

public class VectorComparisonEquality {
	public static void main(String[] args) {
		System.out.println("=== Vector Comparison and Equality ===\n");

		Vector<String> v1 = new Vector<>();
		v1.add("Java");
		v1.add("Python");
		v1.add("C++");

		Vector<String> v2 = new Vector<>();
		v2.add("Java");
		v2.add("Python");
		v2.add("C++");

		Vector<String> v3 = new Vector<>();
		v3.add("Java");
		v3.add("C++");
		v3.add("Python");

		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);
		System.out.println();

		// Method 1: equals(Object o)
		System.out.println("1. equals(Object o):");
		System.out.println("   v1.equals(v2): " + v1.equals(v2));
		System.out.println("   v1.equals(v3): " + v1.equals(v3));
		System.out.println("   (Order matters for equality)");

		// Method 2: hashCode()
		System.out.println("\n2. hashCode():");
		System.out.println("   v1.hashCode(): " + v1.hashCode());
		System.out.println("   v2.hashCode(): " + v2.hashCode());
		System.out.println("   v3.hashCode(): " + v3.hashCode());
		System.out.println("   (Equal objects have same hashCode)");

		// Method 3: toString()
		System.out.println("\n3. toString():");
		System.out.println("   v1.toString(): " + v1.toString());
	}
}
