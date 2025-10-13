package Basic;

//throw creates and throws an exception object at runtime.
//throw keyword is used to manually generate(create)
//throws (send) an exception during program execution.
public class Usethrow {
	private int age;

	// Setter method with validation
	public void setAge(int age) {
		if (age < 0) {
			// Throw an exception if invalid data is passed
			//immediately stops execution and reports invalid input.
			throw new IllegalArgumentException("Age cannot be negative");
		}
		this.age = age;
	}

	// Getter method
	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		Usethrow person=new Usethrow();
		try {
            person.setAge(25); // valid age
            System.out.println("Age set successfully: " + person.getAge());

            person.setAge(-5); // invalid age — will cause exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

}
