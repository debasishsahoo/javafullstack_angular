
/**
 * Utility class demonstrating static methods and method overloading
 */

public class StudentUtils {

	// 11. METHOD OVERLOADING - Same method name, different parameters

	// Find student by ID
	public static Student findStudent(Student[] students, int id) {
		for (Student student : students) {
			if (student != null && student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	// Find student by name
	public static Student findStudent(Student[] students, String name) {
		for (Student student : students) {
			if (student != null && student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}

	// Find students by age range
	public static Student[] findStudent(Student[] students, int minAge, int maxAge) {
		Student[] result = new Student[students.length];
		int count = 0;

		for (Student student : students) {
			if (student != null && student.getAge() >= minAge && student.getAge() <= maxAge) {
				result[count++] = student;
			}
		}

		// Return array with exact size
		Student[] exactResult = new Student[count];
		System.arraycopy(result, 0, exactResult, 0, count);
		return exactResult;
	}
	
	
	
	// 12. VARARGS METHODS
    public static double calculateClassAverage(Student... students) {
        if (students.length == 0) return 0.0;
        
        double total = 0;
        int count = 0;
        
        for (Student student : students) {
            if (student != null) {
                total += student.calculateAverage();
                count++;
            }
        }
        
        return count > 0 ? total / count : 0.0;
    }
    
    public static void printStudentNames(String prefix, Student... students) {
        System.out.println(prefix);
        for (Student student : students) {
            if (student != null) {
                System.out.println("- " + student.getName());
            }
        }
    }

 // 13. GENERIC METHODS
    public static <T> void swap(T[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    // 14. RECURSIVE METHODS
    public static long calculateFactorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * calculateFactorial(n - 1);
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // Binary search recursive method
    public static int binarySearchStudents(Student[] students, int targetId, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (students[mid].getId() == targetId) {
            return mid;
        } else if (students[mid].getId() > targetId) {
            return binarySearchStudents(students, targetId, left, mid - 1);
        } else {
            return binarySearchStudents(students, targetId, mid + 1, right);
        }
    }
    
    // 15. METHODS WITH DIFFERENT ACCESS MODIFIERS
    public static void publicMethod() {
        System.out.println("This is a public method - accessible everywhere");
    }
    
    protected static void protectedMethod() {
        System.out.println("This is a protected method - accessible in package and subclasses");
    }
    
    static void packagePrivateMethod() {
        System.out.println("This is a package-private method - accessible in same package");
    }
    
    private static void privateMethod() {
        System.out.println("This is a private method - only accessible within this class");
    }
    
    // Public method that calls private method
    public static void demonstratePrivateAccess() {
        System.out.println("Calling private method from public method:");
        privateMethod();
    }
    
    
    
    
}
