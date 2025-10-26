package com.java.collection.set;

import java.util.*;

public class SetBasicOperations {
    public static void main(String[] args) {
        System.out.println("=== SET BASIC OPERATIONS ===\n");

        // Creating a HashSet
        Set<String> fruits = new HashSet<>();

        // 1. add(E element) - Adds element if not present
        System.out.println("1. add() Method:");
        System.out.println("Adding 'Apple': " + fruits.add("Apple"));
        System.out.println("Adding 'Banana': " + fruits.add("Banana"));
        System.out.println("Adding 'Orange': " + fruits.add("Orange"));
        System.out.println("Adding 'Apple' again: " + fruits.add("Apple")); // Returns false
        System.out.println("Current Set: " + fruits);
        System.out.println();

        // 2. size() - Returns number of elements
        System.out.println("2. size() Method:");
        System.out.println("Size of set: " + fruits.size());
        System.out.println();

        // 3. contains(Object o) - Checks if element exists
        System.out.println("3. contains() Method:");
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));
        System.out.println("Contains 'Mango': " + fruits.contains("Mango"));
        System.out.println();

        // 4. isEmpty() - Checks if set is empty
        System.out.println("4. isEmpty() Method:");
        System.out.println("Is set empty: " + fruits.isEmpty());
        System.out.println();

        // 5. remove(Object o) - Removes specified element
        System.out.println("5. remove() Method:");
        System.out.println("Removing 'Banana': " + fruits.remove("Banana"));
        System.out.println("Removing 'Mango' (not present): " + fruits.remove("Mango"));
        System.out.println("Current Set: " + fruits);
        System.out.println();

        // 6. addAll(Collection c) - Adds all elements from collection
        System.out.println("6. addAll() Method:");
        Set<String> moreFruits = new HashSet<>(Arrays.asList("Grapes", "Mango", "Apple"));
        System.out.println("Adding collection: " + moreFruits);
        fruits.addAll(moreFruits);
        System.out.println("Set after addAll: " + fruits);
        System.out.println();

        // 7. containsAll(Collection c) - Checks if all elements present
        System.out.println("7. containsAll() Method:");
        Set<String> checkSet = new HashSet<>(Arrays.asList("Apple", "Mango"));
        System.out.println("Contains all of " + checkSet + ": " + fruits.containsAll(checkSet));
        checkSet.add("Watermelon");
        System.out.println("Contains all of " + checkSet + ": " + fruits.containsAll(checkSet));
        System.out.println();

        // 8. removeAll(Collection c) - Removes all elements in collection
        System.out.println("8. removeAll() Method:");
        Set<String> toRemove = new HashSet<>(Arrays.asList("Apple", "Grapes"));
        System.out.println("Removing: " + toRemove);
        fruits.removeAll(toRemove);
        System.out.println("Set after removeAll: " + fruits);
        System.out.println();

        // Re-adding elements for next demos
        fruits.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date"));

        // 9. retainAll(Collection c) - Keeps only elements in collection
        System.out.println("9. retainAll() Method:");
        Set<String> toRetain = new HashSet<>(Arrays.asList("Apple", "Mango", "Cherry"));
        System.out.println("Retaining only: " + toRetain);
        fruits.retainAll(toRetain);
        System.out.println("Set after retainAll: " + fruits);
        System.out.println();

        // 10. iterator() - Returns iterator
        System.out.println("10. iterator() Method:");
        fruits.addAll(Arrays.asList("Banana", "Date", "Elderberry"));
        System.out.print("Iterating through set: ");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");

        // 11. toArray() - Converts to array
        System.out.println("11. toArray() Method:");
        Object[] fruitsArray = fruits.toArray();
        System.out.println("Array: " + Arrays.toString(fruitsArray));

        String[] typedArray = fruits.toArray(new String[0]);
        System.out.println("Typed Array: " + Arrays.toString(typedArray));
        System.out.println();

        // 12. clear() - Removes all elements
        System.out.println("12. clear() Method:");
        System.out.println("Before clear - Size: " + fruits.size());
        fruits.clear();
        System.out.println("After clear - Size: " + fruits.size());
        System.out.println("Is empty: " + fruits.isEmpty());
        System.out.println();

        // 13. equals() - Compares sets
        System.out.println("13. equals() Method:");
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 4, 3, 2, 1)); // Different order
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 3));
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);
        System.out.println("set1.equals(set2): " + set1.equals(set2));
        System.out.println("set1.equals(set3): " + set1.equals(set3));
        System.out.println();

        // 14. hashCode() - Returns hash code
        System.out.println("14. hashCode() Method:");
        System.out.println("HashCode of set1: " + set1.hashCode());
        System.out.println("HashCode of set2: " + set2.hashCode());
        System.out.println("HashCode of set3: " + set3.hashCode());
    }
}
