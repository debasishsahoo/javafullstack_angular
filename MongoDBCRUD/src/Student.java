import java.sql.Date;

import org.bson.Document;

public class Student {
	private String id;
    private String name;
    private int age;
    private String grade;
    private String email;
    private double marks;
    private String city;
    private Date enrollmentDate;
    private Date lastModified;
    
    // Constructor for creating new student
    public Student(String name, int age, String grade, String email, double marks, String city) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.marks = marks;
        this.city = city;
        this.enrollmentDate = new Date();
    }
    
    // Constructor for existing student from database
    public Student(String id, String name, int age, String grade, String email, 
                   double marks, String city, Date enrollmentDate, Date lastModified) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.marks = marks;
        this.city = city;
        this.enrollmentDate = enrollmentDate;
        this.lastModified = lastModified;
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
    public String getEmail() { return email; }
    public double getMarks() { return marks; }
    public String getCity() { return city; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public Date getLastModified() { return lastModified; }
    
    // Convert Student to MongoDB Document
    public Document toDocument() {
        return new Document("name", name)
                .append("age", age)
                .append("grade", grade)
                .append("email", email)
                .append("marks", marks)
                .append("city", city)
                .append("enrollmentDate", enrollmentDate);
    }
    
    // Create Student from MongoDB Document
    public static Student fromDocument(Document doc) {
        return new Student(
            doc.getObjectId("_id").toString(),
            doc.getString("name"),
            doc.getInteger("age"),
            doc.getString("grade"),
            doc.getString("email"),
            doc.getDouble("marks"),
            doc.getString("city"),
            doc.getDate("enrollmentDate"),
            doc.getDate("lastModified")
        );
    }
    
    // Display methods
    public String toTableRow() {
        return String.format("%-26s | %-20s | %-4d | %-8s | %-25s | %-6.2f | %-15s",
                id, name, age, grade, email, marks, city);
    }
    
    public String toDetailedView() {
        StringBuilder sb = new StringBuilder();
        sb.append("🆔 ID:       ").append(id).append("\n");
        sb.append("👤 Name:     ").append(name).append("\n");
        sb.append("🎂 Age:      ").append(age).append("\n");
        sb.append("📚 Grade:    ").append(grade).append("\n");
        sb.append("📧 Email:    ").append(email).append("\n");
        sb.append("📊 Marks:    ").append(marks).append("\n");
        sb.append("🏙️  City:     ").append(city).append("\n");
        
        if (enrollmentDate != null) {
            sb.append("📅 Enrolled: ").append(enrollmentDate).append("\n");
        }
        if (lastModified != null) {
            sb.append("🔄 Modified: ").append(lastModified).append("\n");
        }
        
        return sb.toString();
    }
}
