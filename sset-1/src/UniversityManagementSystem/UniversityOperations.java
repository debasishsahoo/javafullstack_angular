package UniversityManagementSystem;

import java.util.List;

//Utility class to demonstrate complex polymorphic operations
public class UniversityOperations {
 public static double calculateAverageAge(List<Person> people) {
     return people.stream()
                 .mapToInt(Person::getAge)
                 .average()
                 .orElse(0.0);
 }

 public static void promoteToTA(Student student, Professor supervisor) {
     System.out.println("Promoting " + student.getName() + " to Teaching Assistant");
     // In a real system, this would return a new TeachingAssistant object
 }

 public static <T extends Person & Researchable> void awardResearchGrant(T researcher, double amount) {
     System.out.println("Awarding $" + amount + " research grant to " + researcher.getName());
     researcher.conductResearch();
 }
}
