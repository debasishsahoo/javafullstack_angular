package com.java.collection;

import java.util.*;
import java.util.stream.Collectors;

public class ComprehensiveCollectionDemo {
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE COLLECTION INTERFACE DEMO ===\n");
        
        // Create collections
        Collection<Student> students = new ArrayList<>();
        
        students.add(new Student("Alice", 85, "Computer Science"));
        students.add(new Student("Bob", 72, "Mathematics"));
        students.add(new Student("Charlie", 90, "Computer Science"));
        students.add(new Student("David", 65, "Physics"));
        students.add(new Student("Eve", 88, "Mathematics"));
        students.add(new Student("Frank", 78, "Computer Science"));
        
        System.out.println("All Students:");
        students.forEach(s -> System.out.println("  " + s));
        
        // Basic operations
        System.out.println("\n--- Basic Operations ---");
        System.out.println("Total students: " + students.size());
        System.out.println("Is empty? " + students.isEmpty());
        System.out.println("Contains Alice? " + 
                          students.contains(new Student("Alice", 85, "Computer Science")));
        
        // Stream operations
        System.out.println("\n--- Stream Operations ---");
        
        // Filter students with marks > 80
        List<Student> topStudents = students.stream()
                                           .filter(s -> s.getMarks() > 80)
                                           .collect(Collectors.toList());
        System.out.println("Students with marks > 80:");
        topStudents.forEach(s -> System.out.println("  " + s));
        
        // Group by major
        Map<String, List<Student>> byMajor = students.stream()
                                                    .collect(Collectors.groupingBy(Student::getMajor));
        System.out.println("\nStudents grouped by major:");
        byMajor.forEach((major, list) -> {
            System.out.println("  " + major + ": " + list.size() + " students");
        });
        
        // Average marks
        double avgMarks = students.stream()
                                 .mapToInt(Student::getMarks)
                                 .average()
                                 .orElse(0.0);
        System.out.println("\nAverage marks: " + String.format("%.2f", avgMarks));
        
        // removeIf operation
        System.out.println("\n--- RemoveIf Operation ---");
        Collection<Student> studentsToModify = new ArrayList<>(students);
        System.out.println("Before removing low performers: " + studentsToModify.size());
        studentsToModify.removeIf(s -> s.getMarks() < 70);
        System.out.println("After removing students with marks < 70: " + 
                          studentsToModify.size());
        
        // Bulk operations
        System.out.println("\n--- Bulk Operations ---");
        Collection<Student> csStudents = students.stream()
                                                .filter(s -> s.getMajor().equals("Computer Science"))
                                                .collect(Collectors.toList());
        System.out.println("CS Students: " + csStudents.size());
        
        Collection<Student> mathStudents = students.stream()
                                                  .filter(s -> s.getMajor().equals("Mathematics"))
                                                  .collect(Collectors.toList());
        System.out.println("Math Students: " + mathStudents.size());
        
        // Union
        Collection<Student> union = new ArrayList<>(csStudents);
        union.addAll(mathStudents);
        System.out.println("Union (CS + Math): " + union.size());
        
        // Array conversion
        System.out.println("\n--- Array Conversion ---");
        Student[] studentArray = students.toArray(new Student[0]);
        System.out.println("Converted to array. Array length: " + studentArray.length);
        System.out.println("First student in array: " + studentArray[0]);
        
        // Iterator usage
        System.out.println("\n--- Iterator Usage ---");
        Iterator<Student> iterator = students.iterator();
        System.out.println("Iterating through students:");
        int count = 0;
        while (iterator.hasNext() && count < 3) {
            System.out.println("  " + iterator.next());
            count++;
        }
        System.out.println("  ... and " + (students.size() - 3) + " more");
    }
}

class Student {
    private String name;
    private int marks;
    private String major;
    
    public Student(String name, int marks, String major) {
        this.name = name;
        this.marks = marks;
        this.major = major;
    }
    
    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getMajor() { return major; }
    
    @Override
    public String toString() {
        return String.format("%s (Marks: %d, Major: %s)", name, marks, major);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return marks == student.marks && 
               Objects.equals(name, student.name) && 
               Objects.equals(major, student.major);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, marks, major);
    }
}



