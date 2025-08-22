package ComplexDotOperator;

public class Main {
	 public static void main(String[] args) {
		 City city = new City("New York", "10001");
		 Address address = new Address("123 Main St", city);
		 Person person = new Person("John Doe", address);
		 
		 
		// Chaining dot operators to access nested properties
		 
		                   
		 String cityName=person.getAddress().getCity().getName();
		 String zipCode = person.getAddress().getCity().getZipCode();
		 
		 System.out.println("Person: " + person.getName());
	     System.out.println("City: " + cityName);
	     System.out.println("Zip: " + zipCode);
		 
		 
	 }
}
