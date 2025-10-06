package UniversityManagementSystem;

import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create persons of different types
        Student student1 = new Student("Alice Johnson", 20, "Computer Science");
        Student student2 = new Student("Bob Smith", 22, "Mathematics");

        Professor prof1 = new Professor("Dr. Wilson", 45, "Computer Science", "Artificial Intelligence");
        Professor prof2 = new Professor("Dr. Garcia", 50, "Mathematics", "Number Theory");

        TeachingAssistant ta1 = new TeachingAssistant("Carol Lee", 25, "Computer Science", prof1);
        TeachingAssistant ta2 = new TeachingAssistant("David Kim", 24, "Mathematics", prof2);

        // Demonstrate polymorphic behavior through collections
        List<Person> allPeople = Arrays.asList(student1, student2, prof1, prof2, ta1, ta2);
        List<CourseParticipant> courseParticipants = Arrays.asList(student1, prof1, ta1);
        List<Researchable> researchers = Arrays.asList(prof1, prof2, ta1, ta2);

        System.out.println("=== ALL PEOPLE IN UNIVERSITY ===");
        displayAllPeople(allPeople);

        System.out.println("\\n=== COURSE PARTICIPANTS ===");
        manageCourses(courseParticipants);

        System.out.println("\\n=== RESEARCH ACTIVITIES ===");
        conductResearch(researchers);

        System.out.println("\\n=== SPECIFIC BEHAVIORS DEMONSTRATION ===");
        demonstrateSpecificBehaviors(student1, prof1, ta1);

        System.out.println("\\n=== USING SUPER KEYWORD EFFECTS ===");
        demonstrateSuperKeywordUsage(ta1);
    }

    // Polymorphic method - works with any Person subclass
    public static void displayAllPeople(List<Person> people) {
        for (Person person : people) {
            person.displayInfo();  // Runtime polymorphism - calls appropriate implementation

            // Additional role-specific info
            System.out.println("  Courses: " + getCoursesIfApplicable(person));
            System.out.println("---");
        }
    }

    // Helper method demonstrating instanceof and casting
    private static String getCoursesIfApplicable(Person person) {
        if (person instanceof CourseParticipant) {
            CourseParticipant participant = (CourseParticipant) person;
            return participant.getCourses().toString();
        }
        return "N/A";
    }

    // Polymorphic method for course management
    public static void manageCourses(List<CourseParticipant> participants) {
        for (CourseParticipant participant : participants) {
            // Each participant handles enrollment differently (polymorphism)
            participant.enrollCourse("CS101");

            if (participant instanceof Student) {
                participant.enrollCourse("MATH201");
            } else if (participant instanceof Professor) {
                participant.enrollCourse("ADV400");
            }
        }
    }

    // Polymorphic method for research activities
    public static void conductResearch(List<Researchable> researchers) {
        for (Researchable researcher : researchers) {
            researcher.conductResearch();
            researcher.publishPaper("Recent Findings in Field");
        }
    }

    // Demonstrate specific behaviors of each type
    public static void demonstrateSpecificBehaviors(Student student, Professor prof, TeachingAssistant ta) {
        System.out.println("Student behavior:");
        student.submitAssignment("CS101", "Programming Project");

        System.out.println("\\nProfessor behavior:");
        prof.gradeStudent(student, "CS101", 95.5);

        System.out.println("\\nTeaching Assistant behavior:");
        ta.conductLabSession("CS101");
        ta.gradeAssignments("CS101", 30);

        // Demonstrate TA's dual nature
        System.out.println("\\nTA as Student:");
        ta.submitAssignment("ADV400", "Research Paper");

        System.out.println("\\nTA as Researcher:");
        ta.conductResearch();
    }

    // Demonstrate super keyword usage effects
    public static void demonstrateSuperKeywordUsage(TeachingAssistant ta) {
        System.out.println("Original TA details:");
        ta.displayInfo();

        System.out.println("\\nAfter enrolling in a course (demonstrating super call):");
        ta.enrollCourse("New Course");  // This calls super.enrollCourse() internally

        System.out.println("\\nFinal TA details showing inherited + specialized behavior:");
        ta.displayInfo();
    }
}

