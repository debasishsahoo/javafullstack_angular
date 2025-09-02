package This;

//The this keyword is a reference variable,it refers to the current object of the class

public class Student {
	private String name;
	private int age;
	private int value = 10;// instance variable
	private String outerField = "Outer";

	// 1. Distinguishing Instance Variables from Parameters

//	 public Student(String name, int age) {
//		// Without 'this', both would refer to parameter
//		 //name=name;  //Name Ambiguity
//		 //age=age;    
//		 
//		 this.name=name; // this.name refers to instance variable
//		 this.age=age; //age on right refers to parameter
//	 }

	// 2. Invoke another constructor (constructor chaining)
//	Student() {
//		this(0, "Unknown"); // calls parameterized constructor
//	}
//
//	Student(int age, String name) {
//		this.age = age;
//		this.name = name;
//	}

	// 3. Invoke current object’s method
//	void display() {
//		System.out.println("Hello from display()");
//	}
//
//	void show() {
//		this.display(); // calls display()
//	}

	// 5. Return the current object (for method chaining)
//	Student setAge(int age) {
//        this.age = age;
//        return this;
//    }
//
//    Student setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    void display() {
//        System.out.println(age + " " + name);
//    }
//	
//	
//    public static void main(String[] args) {
//    	   Student s = new Student().setAge(101).setName("Alice");
//    	   s.display(); // 101 Alice
//    }

	// 6. Accessing Instance Members in Shadowed Contexts

//	public void method() {
//		 int value = 20; //local variable(Scope is Under the Method Only)
//		 System.out.println(value); // 20 (local variable)
//		 System.out.println(this.value); // 10 (instance variable)
//	}
//	
	// 6. Inner Class Access to Outer Class Instance
	
	class Inner {
        private String innerField = "Inner";
        public void print() {
            System.out.println(innerField); // "Inner"
            System.out.println(this.innerField); // "Inner"
            
            System.out.println(Student.this.outerField); // "Outer" - access outer instance
        }
	}

}
