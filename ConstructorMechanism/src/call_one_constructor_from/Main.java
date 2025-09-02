package call_one_constructor_from;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(); // calls default constructor → chains to 2-param
		Student s2 = new Student(101); // calls 1-param constructor → chains to 2-param
		Student s3 = new Student(102, "Alice"); // directly calls 2-param constructor

		s1.display(); // 0 Unknown
		s2.display(); // 101 Unnamed
		s3.display(); // 102 Alice
	}
}
