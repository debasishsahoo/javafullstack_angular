package ComplexDotOperator;

public class Address {
	private String street;
	private City city; //HAS-A

	public Address(String street, City city) {
		this.street = street;
		this.city = city;
	}

	public City getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}
}
