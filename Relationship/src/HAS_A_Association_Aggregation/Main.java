package HAS_A_Association_Aggregation;

public class Main {

	public static void main(String[] args) {
		Professor prof = new Professor("Dr. Debasish Sahoo");// Independent object
		Department dept = new Department("Computer Science", prof);
		// If the department is deleted,Professor Dr. Debasish Sahoo  still exists
	}

}
