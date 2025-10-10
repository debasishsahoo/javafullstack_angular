package set1;

public class Employee {
	// Private variables (data hiding)
	private String name;
	private int age;
	private double salary;

	// Public getter for name
	public String getName() {
		return name;
	}

	// Public setter for name with validation
	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}

	// Public getter for age
	public int getAge() {
		return age;
	}

	// Public setter for age with validation
	public void setAge(int age) {
		if (age > 0 && age < 100) {
			this.age = age;
		}
	}
	
	 // Public getter for salary
    public double getSalary() {
        return salary;
    }
    
    // Public setter for salary with validation
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }
	
	

}
