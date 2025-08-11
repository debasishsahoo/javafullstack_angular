
/**
 * Student class demonstrating various method types Shows instance methods,
 * constructors, getters/setters, overriding
 */

public class Student {
	// Instance variables
	private int id;
	private String name;
	private int age;
	private double[] grades;
	private static int totalStudents = 0; // Static variable

	// 1. CONSTRUCTOR METHODS
	// Default constructor
	public Student() {
		this.id = ++totalStudents;
		this.name = "Unknown";
		this.age = 18;
		this.grades = new double[5];
		System.out.println("Default constructor called for Student ID: " + this.id);
	}
	
	// Parameterized constructor - CONSTRUCTOR OVERLOADING
    public Student(String name, int age) {
        this.id = ++totalStudents;
        this.name = name;
        this.age = age;
        this.grades = new double[5];
        System.out.println("Parameterized constructor called for: " + name+ " and Age: "+age);
    }
	
 // Full constructor
    public Student(String name, int age, double[] grades) {
        this.id = ++totalStudents;
        this.name = name;
        this.age = age;
        this.grades = grades.clone();  // Defensive copying
        System.out.println("Full constructor called for: " + name+ " and Age: "+age+" and Grade"+grades);
    }

	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static void main(String[] args) {
		
		Student stuObj1=new Student();
		Student stuObj2=new Student("Deb",34);
		

	}

}
