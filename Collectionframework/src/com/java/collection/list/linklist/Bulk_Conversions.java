package com.java.collection.list.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Bulk_Conversions {

	public static void main(String[] args) {

		System.out.println("=== LINKEDLIST BULK OPERATIONS & CONVERSIONS ===\n");

		demonstrateBulkOperations();
		demonstrateConversionOperations();
	}

	// BULK OPERATIONS
	public static void demonstrateBulkOperations() {

		System.out.println("\n--- BULK OPERATIONS ---");

		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll(Arrays.asList("A", "B", "C"));
		System.out.println("list1: " + list1);

		LinkedList<String> list2 = new LinkedList<>();
		list2.addAll(Arrays.asList("B", "C", "D"));
		System.out.println("list2: " + list2);

		// addAll(Collection c)
		LinkedList<String> combined = new LinkedList<>(list1);
		combined.addAll(list2);
		System.out.println("\naddAll(list2): " + combined);

		// addAll(int index, Collection c)
		LinkedList<String> inserted = new LinkedList<>(list1);
		inserted.addAll(1, Arrays.asList("X", "Y"));
		System.out.println("addAll(1, ['X','Y']): " + inserted);

		// removeAll(Collection c) - removes all occurrences
		LinkedList<String> removed = new LinkedList<>(combined);
		removed.removeAll(list2);
		System.out.println("\nremoveAll(list2): " + removed);

		// retainAll(Collection c) - keeps only common elements
		LinkedList<String> retained = new LinkedList<>(combined);
		retained.retainAll(list1);
		System.out.println("retainAll(list1): " + retained);

		// containsAll(Collection c)
		boolean hasAll = list1.containsAll(Arrays.asList("A", "B"));
		System.out.println("\ncontainsAll(['A','B']): " + hasAll);
		System.out.println("containsAll(['A','X']): " + list1.containsAll(Arrays.asList("A", "X")));

		// replaceAll(UnaryOperator) - Java 8+
		LinkedList<String> replaceList = new LinkedList<>();
		replaceList.addAll(Arrays.asList("apple", "banana", "cherry"));
		System.out.println("\nBefore replaceAll: " + replaceList);
		replaceList.replaceAll(String::toUpperCase);
		System.out.println("After replaceAll(toUpperCase): " + replaceList);

		// sort(Comparator) - Java 8+
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
		System.out.println("\nBefore sort: " + numbers);
		numbers.sort(Comparator.naturalOrder());
		System.out.println("After sort (ascending): " + numbers);
		numbers.sort(Comparator.reverseOrder());
		System.out.println("After sort (descending): " + numbers);
	}

	// CONVERSION OPERATIONS
	public static void demonstrateConversionOperations() {
		System.out.println("\n--- CONVERSION OPERATIONS ---");

		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
		System.out.println("Original LinkedList: " + list);

		// 1. toArray() - returns Object[]
		Object[] objArray = list.toArray();
		System.out.println("\n1. toArray(): " + Arrays.toString(objArray));

		// 2. toArray(T[] a) - returns typed array
		String[] strArray = list.toArray(new String[0]);
		System.out.println("2. toArray(String[]): " + Arrays.toString(strArray));

		// Alternative syntax
		String[] strArray2 = list.toArray(new String[list.size()]);
		System.out.println("   toArray(sized array): " + Arrays.toString(strArray2));

		// 3. Convert to ArrayList
		ArrayList<String> arrayList = new ArrayList<>(list);
		System.out.println("\n3. To ArrayList: " + arrayList);

		// 4. Convert to HashSet (removes duplicates)
		list.add("Apple"); // Add duplicate
		HashSet<String> hashSet = new HashSet<>(list);
		System.out.println("\n4. To HashSet: " + hashSet);

		// 5. Convert to TreeSet (sorted, no duplicates)
		TreeSet<String> treeSet = new TreeSet<>(list);
		System.out.println("5. To TreeSet: " + treeSet);

		// 6. Convert to Array using Stream
		String[] streamArray = list.stream().toArray(String[]::new);
		System.out.println("\n6. Stream to Array: " + Arrays.toString(streamArray));

		// 7. Convert to List using Stream
		List<String> streamList = list.stream().collect(Collectors.toList());
		System.out.println("7. Stream to List: " + streamList);

		// 8. Convert to comma-separated String
		String joined = String.join(", ", list);
		System.out.println("\n8. To String (joined): " + joined);

		// 9. Convert using Stream collectors
		String csv = list.stream().collect(Collectors.joining(", "));
		System.out.println("9. Stream joining: " + csv);

		// 10. Convert to Map (using index as key)
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(i, list.get(i));
		}
		System.out.println("\n10. To Map: " + map);

		// 11. Filter and collect
		List<String> filtered = list.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
		System.out.println("\n11. Filtered (length > 5): " + filtered);

		// 12. Transform and collect
		List<String> transformed = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("12. Transformed (uppercase): " + transformed);
	}
}
