package DefensiveCopying;

import java.util.Date;

public class Person1 {
	private Date birthDate;

	public Person1(Date birthDate) {
		// Defensive copy in constructor
		this.birthDate = new Date(birthDate.getTime());
	}

	public Date getBirthDate() {
		// Defensive copy in getter
		return new Date(birthDate.getTime());
	}

	public static void main(String[] args) {
		Date date = new Date();
		Person1 p = new Person1(date);
		System.out.println("Before change: " + p.getBirthDate());

		// External modification
		date.setYear(2000); // changes original Date object!

		System.out.println("After external change: " + p.getBirthDate());

	}
}
