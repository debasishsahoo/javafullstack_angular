package UniversityManagementSystem;

import java.util.List;

public interface CourseParticipant {
	void enrollCourse(String course);
    void dropCourse(String course);
    List<String> getCourses();
}
