package com.java.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMathematicalOperations {
	public static void main(String[] args) {
		System.out.println("=== SET MATHEMATICAL OPERATIONS ===\n");

		// Initialize sets for demonstrations
		Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
		Set<Integer> setC = new HashSet<>(Arrays.asList(1, 2, 3));

		System.out.println("Set A: " + setA);
		System.out.println("Set B: " + setB);
		System.out.println("Set C: " + setC);
		System.out.println();

		// 1. UNION - All elements from both sets
		System.out.println("1. UNION (A ∪ B):");
		Set<Integer> union = new HashSet<>(setA);
		union.addAll(setB);
		System.out.println("Result: " + union);
		System.out.println();

		// 2. INTERSECTION - Common elements
		System.out.println("2. INTERSECTION (A ∩ B):");
		Set<Integer> intersection = new HashSet<>(setA);
		intersection.retainAll(setB);
		System.out.println("Result: " + intersection);
		System.out.println();

		// 3. DIFFERENCE - Elements in A but not in B
		System.out.println("3. DIFFERENCE (A - B):");
		Set<Integer> difference = new HashSet<>(setA);
		difference.removeAll(setB);
		System.out.println("Result: " + difference);
		System.out.println();

		// 4. SYMMETRIC DIFFERENCE - Elements in A or B but not both
		System.out.println("4. SYMMETRIC DIFFERENCE (A Δ B):");
		Set<Integer> symDiff = new HashSet<>(setA);
		symDiff.addAll(setB);
		Set<Integer> temp = new HashSet<>(setA);
		temp.retainAll(setB);
		symDiff.removeAll(temp);
		System.out.println("Result: " + symDiff);
		System.out.println();

		// 5. SUBSET - Check if C is subset of A
		System.out.println("5. SUBSET (C ⊆ A):");
		boolean isSubset = setA.containsAll(setC);
		System.out.println("Is C subset of A: " + isSubset);
		System.out.println("Is B subset of A: " + setA.containsAll(setB));
		System.out.println();

		// 6. SUPERSET - Check if A is superset of C
		System.out.println("6. SUPERSET (A ⊇ C):");
		boolean isSuperset = setA.containsAll(setC);
		System.out.println("Is A superset of C: " + isSuperset);
		System.out.println();

		// 7. DISJOINT - No common elements
		System.out.println("7. DISJOINT SETS:");
		Set<Integer> setD = new HashSet<>(Arrays.asList(10, 11, 12));
		System.out.println("Set D: " + setD);
		boolean disjoint = Collections.disjoint(setA, setD);
		System.out.println("Are A and D disjoint: " + disjoint);
		System.out.println("Are A and B disjoint: " + Collections.disjoint(setA, setB));
		System.out.println();

		// 8. CARTESIAN PRODUCT
		System.out.println("8. CARTESIAN PRODUCT (A × C):");
		Set<String> cartesianProduct = new HashSet<>();
		for (Integer a : setA) {
			for (Integer c : setC) {
				cartesianProduct.add("(" + a + "," + c + ")");
			}
		}
		System.out.println("Result: " + cartesianProduct);
		System.out.println();

		// 9. POWER SET
		System.out.println("9. POWER SET of {1, 2, 3}:");
		Set<Integer> smallSet = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Set<Integer>> powerSet = generatePowerSet(smallSet);
		System.out.println("Power Set (2^n = " + powerSet.size() + " subsets):");
		for (Set<Integer> subset : powerSet) {
			System.out.println("  " + subset);
		}
	}

	// Helper method to generate power set
	private static <T> Set<Set<T>> generatePowerSet(Set<T> originalSet) {
		Set<Set<T>> powerSet = new HashSet<>();
		if (originalSet.isEmpty()) {
			powerSet.add(new HashSet<>());
			return powerSet;
		}

		List<T> list = new ArrayList<>(originalSet);
		T head = list.get(0);
		Set<T> rest = new HashSet<>(list.subList(1, list.size()));

		for (Set<T> set : generatePowerSet(rest)) {
			Set<T> newSet = new HashSet<>();
			newSet.add(head);
			newSet.addAll(set);
			powerSet.add(newSet);
			powerSet.add(set);
		}

		return powerSet;
	}
}
