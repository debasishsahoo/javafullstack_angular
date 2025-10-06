package UniversityManagementSystem;

public abstract class Person implements Identifiable {
	protected String name;
	protected int age;
	protected String id;
	protected static int nextId = 1000;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = "P" + nextId++;
	}

	// Abstract method to be implemented by subclasses
	public abstract String getRole();

	// Common implementation
	@Override
	public String getDetails() {
		return String.format("ID: %s, Name: %s, Age: %d, Role: %s", id, name, age, getRole());
	}

	@Override
	public void displayInfo() {
		System.out.println(getDetails());
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}
}
