package com.java.collection.set.enumset;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class EnumSetDemo {

	enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	enum Priority {
		LOW, MEDIUM, HIGH, CRITICAL
	}

	public static void main(String[] args) {
		System.out.println("=== ENUMSET DEMONSTRATION ===\n");

		// 1. Creating EnumSet - allOf
		System.out.println("1. allOf() - All enum constants:");
		EnumSet<Day> allDays = EnumSet.allOf(Day.class);
		System.out.println("All days: " + allDays);
		System.out.println();

		// 2. Creating EnumSet - noneOf
		System.out.println("2. noneOf() - Empty set:");
		EnumSet<Day> noDays = EnumSet.noneOf(Day.class);
		System.out.println("No days: " + noDays);
		noDays.add(Day.MONDAY);
		noDays.add(Day.FRIDAY);
		System.out.println("After adding: " + noDays);
		System.out.println();

		// 3. Creating EnumSet - of
		System.out.println("3. of() - Specific elements:");
		EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
		System.out.println("Weekend: " + weekend);

		EnumSet<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
		System.out.println("Weekdays: " + weekdays);
		System.out.println();

		// 4. Creating EnumSet - range
		System.out.println("4. range() - Range of elements:");
		EnumSet<Day> midWeek = EnumSet.range(Day.TUESDAY, Day.THURSDAY);
		System.out.println("Mid-week (Tue-Thu): " + midWeek);
		System.out.println();

		// 5. Creating EnumSet - complementOf
		System.out.println("5. complementOf() - Complement of a set:");
		EnumSet<Day> notWeekend = EnumSet.complementOf(weekend);
		System.out.println("Weekend: " + weekend);
		System.out.println("Not weekend: " + notWeekend);
		System.out.println();

		// 6. Creating EnumSet - copyOf
		System.out.println("6. copyOf() - Copy from another set:");
		EnumSet<Day> workDays = EnumSet.copyOf(weekdays);
		System.out.println("Work days copy: " + workDays);

		Collection<Day> dayList = Arrays.asList(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);
		EnumSet<Day> fromCollection = EnumSet.copyOf(dayList);
		System.out.println("From collection: " + fromCollection);
		System.out.println();

		// 7. Set operations
		System.out.println("7. Set Operations:");
		EnumSet<Priority> set1 = EnumSet.of(Priority.LOW, Priority.MEDIUM);
		EnumSet<Priority> set2 = EnumSet.of(Priority.MEDIUM, Priority.HIGH);

		System.out.println("Set1: " + set1);
		System.out.println("Set2: " + set2);

		EnumSet<Priority> union = EnumSet.copyOf(set1);
		union.addAll(set2);
		System.out.println("Union: " + union);

		EnumSet<Priority> intersection = EnumSet.copyOf(set1);
		intersection.retainAll(set2);
		System.out.println("Intersection: " + intersection);

		EnumSet<Priority> difference = EnumSet.copyOf(set1);
		difference.removeAll(set2);
		System.out.println("Difference (set1 - set2): " + difference);
		System.out.println();

		// 8. Performance demonstration
		System.out.println("8. Performance Test:");
		EnumSet<Day> perfSet = EnumSet.noneOf(Day.class);

		long start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			perfSet.add(Day.MONDAY);
			perfSet.contains(Day.MONDAY);
			perfSet.remove(Day.MONDAY);
		}
		long enumSetTime = System.nanoTime() - start;

		Set<Day> hashSet = new HashSet<>();
		start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			hashSet.add(Day.MONDAY);
			hashSet.contains(Day.MONDAY);
			hashSet.remove(Day.MONDAY);
		}
		long hashSetTime = System.nanoTime() - start;

		System.out.println("EnumSet time: " + enumSetTime / 1000000.0 + " ms");
		System.out.println("HashSet time: " + hashSetTime / 1000000.0 + " ms");
		System.out.println("EnumSet is " + (hashSetTime / (double) enumSetTime) + "x faster");
		System.out.println();

		// 9. Iteration
		System.out.println("9. Iteration (maintains declaration order):");
		EnumSet<Day> allDaysIter = EnumSet.allOf(Day.class);
		System.out.print("Days: ");
		for (Day day : allDaysIter) {
			System.out.print(day + " ");
		}
		System.out.println("\n");

		// 10. Cannot add null
		System.out.println("10. Null Element Test:");
		try {
			EnumSet<Day> nullTest = EnumSet.noneOf(Day.class);
			nullTest.add(null);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException: EnumSet doesn't allow null");
		}
	}
}
