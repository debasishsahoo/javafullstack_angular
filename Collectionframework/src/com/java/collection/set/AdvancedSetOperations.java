package com.java.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AdvancedSetOperations {
	public static void main(String[] args) {
		System.out.println("=== ADVANCED SET OPERATIONS ===\n");

		// 1. Set with Streams
		System.out.println("1. Set with Streams:");
		Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		Set<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println("Even numbers: " + evenNumbers);

		Set<Integer> squared = numbers.stream().map(n -> n * n).collect(Collectors.toSet());
		System.out.println("Squared numbers: " + squared);
		System.out.println();

		// 2. Removing duplicates from List
		System.out.println("2. Removing Duplicates:");
		List<String> listWithDuplicates = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Grapes");
		System.out.println("Original List: " + listWithDuplicates);

		Set<String> uniqueSet = new LinkedHashSet<>(listWithDuplicates);
		System.out.println("Unique elements (order preserved): " + uniqueSet);

		List<String> uniqueList = new ArrayList<>(uniqueSet);
		System.out.println("Back to List: " + uniqueList);
		System.out.println();

		// 3. Finding duplicates
		System.out.println("3. Finding Duplicates:");
		List<Integer> numbersWithDups = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 5);
		Set<Integer> seen = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();

		for (Integer num : numbersWithDups) {
			if (!seen.add(num)) {
				duplicates.add(num);
			}
		}
		System.out.println("Original: " + numbersWithDups);
		System.out.println("Duplicates found: " + duplicates);
		System.out.println();

		// 4. Set views
		System.out.println("4. Unmodifiable Set:");
		Set<String> modifiable = new HashSet<>(Arrays.asList("A", "B", "C"));
		Set<String> unmodifiable = Collections.unmodifiableSet(modifiable);
		System.out.println("Unmodifiable set: " + unmodifiable);

		try {
			unmodifiable.add("D");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify: UnsupportedOperationException");
		}
		System.out.println();

		// 5. Singleton set
		System.out.println("5. Singleton Set:");
		Set<String> singletonSet = Collections.singleton("OnlyElement");
		System.out.println("Singleton: " + singletonSet);
		System.out.println("Size: " + singletonSet.size());
		System.out.println();

		// 6. Empty set
		System.out.println("6. Empty Set:");
		Set<String> emptySet = Collections.emptySet();
		System.out.println("Empty set: " + emptySet);
		System.out.println("Is empty: " + emptySet.isEmpty());
		System.out.println();

		// 7. Converting between different Set types
		System.out.println("7. Converting Between Set Types:");
		Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 2, 8, 1, 9));
		System.out.println("HashSet: " + hashSet);

		Set<Integer> treeSet = new TreeSet<>(hashSet);
		System.out.println("TreeSet (sorted): " + treeSet);

		Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(5, 2, 8, 1, 9));
		System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
		System.out.println();

		// 8. Bulk operations
		System.out.println("8. Bulk Operations:");
		Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
		Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E", "F"));

		System.out.println("Set1: " + set1);
		System.out.println("Set2: " + set2);

		Set<String> bulkTest = new HashSet<>(set1);
		bulkTest.addAll(set2);
		System.out.println("After addAll: " + bulkTest);

		bulkTest = new HashSet<>(set1);
		bulkTest.retainAll(set2);
		System.out.println("After retainAll: " + bulkTest);

		bulkTest = new HashSet<>(set1);
		bulkTest.removeAll(set2);
		System.out.println("After removeAll: " + bulkTest);
		System.out.println();

		// 9. Set with custom sorting
		System.out.println("9. Custom Sorting:");
		Set<String> customSort = new TreeSet<>((s1, s2) -> {
			// Sort by length, then alphabetically
			int lenCompare = Integer.compare(s1.length(), s2.length());
			return lenCompare != 0 ? lenCompare : s1.compareTo(s2);
		});

		customSort.addAll(Arrays.asList("Apple", "Fig", "Banana", "Kiwi", "Orange"));
		System.out.println("Sorted by length: " + customSort);
		System.out.println();

		// 10. Checking set equality
		System.out.println("10. Set Equality:");
		Set<Integer> setX = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> setY = new LinkedHashSet<>(Arrays.asList(3, 2, 1));
		Set<Integer> setZ = new TreeSet<>(Arrays.asList(1, 2, 3));

		System.out.println("HashSet: " + setX);
		System.out.println("LinkedHashSet: " + setY);
		System.out.println("TreeSet: " + setZ);
		System.out.println("All equal? " + (setX.equals(setY) && setY.equals(setZ)));
		System.out.println(
				"Same hashCode? " + (setX.hashCode() == setY.hashCode() && setY.hashCode() == setZ.hashCode()));
	}
}
