import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class StudentDAO {
	private MongoCollection<Document> collection;

	public StudentDAO() {
		this.collection = DatabaseConfig.getCollection();
	}

	// CREATE
	public String addStudent(Student student) {
		try {
			Document doc = student.toDocument();
			collection.insertOne(doc);
			return doc.getObjectId("_id").toString();
		} catch (Exception e) {
			throw new RuntimeException("Error adding student: " + e.getMessage());
		}
	}
	// READ ALL
    public List<Student> getAllStudents() {
        try {
            List<Student> students = new ArrayList<>();
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    students.add(Student.fromDocument(cursor.next()));
                }
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving students: " + e.getMessage());
        }
    }
    
 // READ BY ID
    public Student getStudentById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            Document doc = collection.find(Filters.eq("_id", objectId)).first();
            return doc != null ? Student.fromDocument(doc) : null;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID format");
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving student: " + e.getMessage());
        }
    }
    
 // SEARCH BY NAME
    public List<Student> searchByName(String name) {
        try {
            List<Student> students = new ArrayList<>();
            Bson filter = Filters.regex("name", name, "i");
            try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
                while (cursor.hasNext()) {
                    students.add(Student.fromDocument(cursor.next()));
                }
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException("Error searching students: " + e.getMessage());
        }
    }
    // FILTER BY GRADE
    public List<Student> filterByGrade(String grade) {
        try {
            List<Student> students = new ArrayList<>();
            Bson filter = Filters.regex("grade", grade, "i");
            try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
                while (cursor.hasNext()) {
                    students.add(Student.fromDocument(cursor.next()));
                }
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException("Error filtering students: " + e.getMessage());
        }
    }
    
    // UPDATE
    public boolean updateStudent(String id, String name, int age, String grade, 
                                 String email, double marks, String city) {
        try {
            ObjectId objectId = new ObjectId(id);
            Bson updates = Updates.combine(
                    Updates.set("name", name),
                    Updates.set("age", age),
                    Updates.set("grade", grade),
                    Updates.set("email", email),
                    Updates.set("marks", marks),
                    Updates.set("city", city),
                    Updates.set("lastModified", new Date())
            );
            
            UpdateResult result = collection.updateOne(Filters.eq("_id", objectId), updates);
            return result.getModifiedCount() > 0;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID format");
        } catch (Exception e) {
            throw new RuntimeException("Error updating student: " + e.getMessage());
        }
    }
    
 // UPDATE MARKS ONLY
    public boolean updateMarks(String id, double marks) {
        try {
            ObjectId objectId = new ObjectId(id);
            UpdateResult result = collection.updateOne(
                    Filters.eq("_id", objectId),
                    Updates.set("marks", marks)
            );
            return result.getModifiedCount() > 0;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID format");
        } catch (Exception e) {
            throw new RuntimeException("Error updating marks: " + e.getMessage());
        }
    }
    
    // DELETE
    public boolean deleteStudent(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            DeleteResult result = collection.deleteOne(Filters.eq("_id", objectId));
            return result.getDeletedCount() > 0;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID format");
        } catch (Exception e) {
            throw new RuntimeException("Error deleting student: " + e.getMessage());
        }
    }
    // DELETE BY GRADE
    public long deleteByGrade(String grade) {
        try {
            DeleteResult result = collection.deleteMany(Filters.regex("grade", grade, "i"));
            return result.getDeletedCount();
        } catch (Exception e) {
            throw new RuntimeException("Error deleting students: " + e.getMessage());
        }
    }
    
 // GET STATISTICS
    public StudentStatistics getStatistics() {
        try {
            long totalStudents = collection.countDocuments();
            
            List<String> grades = collection.distinct("grade", String.class).into(new ArrayList<>());
            List<String> cities = collection.distinct("city", String.class).into(new ArrayList<>());
            
            double avgMarks = 0;
            if (totalStudents > 0) {
                List<Document> students = new ArrayList<>();
                collection.find().into(students);
                
                double totalMarks = 0;
                for (Document student : students) {
                    totalMarks += student.getDouble("marks");
                }
                avgMarks = totalMarks / totalStudents;
            }
            
            return new StudentStatistics(totalStudents, grades.size(), cities.size(), grades, cities, avgMarks);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving statistics: " + e.getMessage());
        }
    }
    // COUNT BY GRADE
    public long countByGrade(String grade) {
        return collection.countDocuments(Filters.regex("grade", grade, "i"));
    }
    
}
