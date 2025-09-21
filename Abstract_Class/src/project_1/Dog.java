package project_1;

class Dog extends Animal {
	 private String breed;
	    
	    public Dog(String name, int age, String breed) {
	        super(name, age);
	        this.breed = breed;
	    }
	    
	    @Override
	    public void makeSound() {
	        System.out.println(name + " barks: Woof! Woof!");
	    }
	    
	    @Override
	    public void move() {
	        System.out.println(name + " runs on four legs");
	    }
	    
	    @Override
	    public void eat(String food) {
	        System.out.println(name + " eagerly eats " + food);
	    }
	    
	    // Dog-specific method
	    public void wagTail() {
	        System.out.println(name + " wags tail excitedly!");
	    }
	    
	    @Override
	    public String getInfo() {
	        return super.getInfo() + ", Breed: " + breed;
	    }
}
