package AlternativeCreation.BuilderPattern;

public class Student {
	private final String name; // Required
	private final int age; // Required
	private final String email; // Optional
	private final String address; // Optional
	private final String phone; // Optional

	// Private constructor
	private Student(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.email = builder.email;
		this.address = builder.address;
		this.phone = builder.phone;
	}

	// Static nested Builder class
	public static class Builder {
		private String name; // Required
		private int age; // Required
		private String email; // Optional
		private String address; // Optional
		private String phone; // Optional

		// public Builder() {}

		public Builder(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public static void main(String[] args) {
		Student student = new Student.Builder("John", 20)
				.setEmail("john@email.com")
				.setAddress("123 Main St")
				.build();
	}

}
