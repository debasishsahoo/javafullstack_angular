package upcasting;

 class Dog extends Animal{
	// Overriding superclass method
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    // Method specific to Dog
    public void wagTail() {
        System.out.println("Wagging tail");
    }
}
