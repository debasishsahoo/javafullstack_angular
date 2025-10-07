package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements CourseParticipant{
	private List<String> courses;
    private double gpa;
    private String major;
    
    public Student(String name, int age, String major) {
        super(name, age);  // Using super to call parent constructor
        this.major = major;
        this.courses = new ArrayList<>();
        this.gpa = 0.0;
    }
    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void enrollCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println(name + " enrolled in " + course);
        }
    }

    @Override
    public void dropCourse(String course) {
        if (courses.remove(course)) {
            System.out.println(name + " dropped " + course);
        }
    }
    
    @Override
    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public void calculateGPA(double[] grades) {
        if (grades.length > 0) {
            double sum = 0;
            for (double grade : grades) sum += grade;
            this.gpa = sum / grades.length;
        }
    }

    public double getGpa() { return gpa; }
    public String getMajor() { return major; }

    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Major: %s, GPA: %.2f", major, gpa);
    }

    // Student-specific behavior
    public void submitAssignment(String course, String assignment) {
        System.out.println(name + " submitted " + assignment + " for " + course);
    }

}
