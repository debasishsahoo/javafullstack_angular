package project_1;

class Fish extends Animal{
	 private String waterType;
	    
	    public Fish(String name, int age, String waterType) {
	        super(name, age);
	        this.waterType = waterType;
	    }
	    
	    @Override
	    public void makeSound() {
	        System.out.println(name + " makes bubbles: Blub blub...");
	    }
	    
	    @Override
	    public void move() {
	        System.out.println(name + " swims gracefully in " + waterType + " water");
	    }
	    
	    @Override
	    public void eat(String food) {
	        System.out.println(name + " gulps down " + food);
	    }

}
