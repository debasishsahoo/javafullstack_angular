package ComplexDotOperator;

public class Person {
	private String name;
	private Address address; //HAS-A

	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}
}
