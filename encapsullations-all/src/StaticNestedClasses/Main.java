package StaticNestedClasses;

public class Main {
	 public static void main(String[] args) {
	        // Creating a User object using Builder Pattern
	        User user = new User.Builder("john_doe", "john@example.com")
	                .firstName("John")
	                .lastName("Doe")
	                .age(30)
	                .build();

	        // Display user details
	        System.out.println("Username: " + user.getUsername());
	        System.out.println("Email: " + user.getEmail());
	        System.out.println("First Name: " + user.getFirstName());
	        System.out.println("Last Name: " + user.getLastName());
	        System.out.println("Age: " + user.getAge());
	    }
}
