package ImmutableClasses;

import java.util.ArrayList;
import java.util.List;

public class ImmutablePerson {
	private final String name;
	private final int age;
	private final List<String> hobbies;

	public ImmutablePerson(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		// Defensive copy of mutable parameter
		this.hobbies = new ArrayList<>(hobbies);
	}

	// Only getters, no setters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// Return defensive copy
	public List<String> getHobbies() {
		return new ArrayList<>(hobbies);
	}

	// To "modify", create a new instance
	public ImmutablePerson withAge(int newAge) {
		return new ImmutablePerson(this.name, newAge, this.hobbies);
	}

}
