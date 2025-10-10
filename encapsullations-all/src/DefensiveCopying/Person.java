package DefensiveCopying;

import java.util.Date;

public class Person {
	private Date birthDate;   // mutable object
	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public static void main(String[] args) {
		Date date = new Date();
		Person p = new Person(date);
		System.out.println("Before change: " + p.getBirthDate());
		
		// External modification
		date.setYear(2000); // changes original Date object!
		
		System.out.println("After external change: " + p.getBirthDate());

	}

}
