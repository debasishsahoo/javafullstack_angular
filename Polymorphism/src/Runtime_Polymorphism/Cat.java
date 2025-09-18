package Runtime_Polymorphism;

class Cat extends Animal{
	  @Override
	    public void makeSound() {
	        System.out.println("The cat meows: Meow!");
	    }
	    
	    @Override
	    public void sleep() {
	        System.out.println("The cat sleeps on the couch");
	    }

}
