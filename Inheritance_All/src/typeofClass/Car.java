package typeofClass;

//// The 'extends' keyword establishes the inheritance
class Car extends Vehicle { // THE SUBCLASS (Child)
	// New, specific field only for Cars
	private int doors;

	// New, specific behavior only for Cars
	public void honk() {
		System.out.println("Car is honking");
	}
	// This method OVERRIDES the inherited start() & move() method for more specific
	// behavior
	
	@Override
	public void start() {
		System.out.println("Car engine is starting");
	}
	
	@Override
    public void move() {
        System.out.println("The car is driving on the road.");
    }
	
	 // A method to display all properties, including the inherited 'brand'
    public void displayDetails() {
        System.out.println("Brand: " + brand); // Inherited from Vehicle
        System.out.println("Doors: " + doors); // Specific to Car
    }


}
