package StaticNestedClasses;

public class User {
	private final String username;
	private final String email;
	private final String firstName;
	private final String lastName;
	private final int age;

	// Private constructor - can only be called by Builder
	private User(Builder builder) {
		this.username = builder.username;
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
	}

	// Getters only
	public String getUsername() {return username;}
	public String getEmail() {return email;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public int getAge() {return age;}

	// Static nested Builder class
	public static class Builder {
		private final String username;  // Required
        private final String email;     // Required
        private String firstName = "";
        private String lastName = "";
        private int age = 0;
        
        public Builder(String username, String email) {
            this.username = username;
            this.email = email;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
        
        
	}
	
	 
     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
