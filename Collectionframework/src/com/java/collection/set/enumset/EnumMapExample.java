package com.java.collection.set.enumset;

import java.util.EnumMap;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapExample {
    public static void main(String[] args) {
        // Create EnumMap with enum type Day as key
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        // Adding key-value pairs
        schedule.put(Day.MONDAY, "Team Meeting");
        schedule.put(Day.TUESDAY, "Development Work");
        schedule.put(Day.WEDNESDAY, "Code Review");
        schedule.put(Day.THURSDAY, "Testing");
        schedule.put(Day.FRIDAY, "Project Deployment");
        schedule.put(Day.SATURDAY, "Maintenance");
        schedule.put(Day.SUNDAY, "Off");

        // Display the EnumMap
        System.out.println("=== Weekly Schedule ===");
        for (Day day : schedule.keySet()) {
            System.out.println(day + " → " + schedule.get(day));
        }

        System.out.println("\nContains Key FRIDAY? " + schedule.containsKey(Day.FRIDAY));
        System.out.println("Contains Value 'Off'? " + schedule.containsValue("Off"));

        // Remove an entry
        schedule.remove(Day.SATURDAY);
        System.out.println("\nAfter Removing SATURDAY: " + schedule);

        // Replace a value
        schedule.replace(Day.MONDAY, "Client Meeting");
        System.out.println("After Replacing MONDAY Task: " + schedule);

        // Size of EnumMap
        System.out.println("\nTotal Days in Schedule: " + schedule.size());
    }
}

