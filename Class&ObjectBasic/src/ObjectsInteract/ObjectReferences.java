package ObjectsInteract;


class Student {
    String name;
    Course course; // Reference to another object

    Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    void showInfo() {
        System.out.println(name + " is enrolled in " + course.name);
    }
}
class Course {
    String name;
    Course(String name) {
        this.name = name;
    }
}

public class ObjectReferences {
	public static void main(String[] args) {
        Course javaCourse = new Course("Java Programming");
        Student student = new Student("Alice", javaCourse); // Student interacts with Course
        student.showInfo();
    }
}
