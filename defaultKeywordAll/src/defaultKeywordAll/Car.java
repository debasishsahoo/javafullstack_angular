package defaultKeywordAll;

class Car implements Vehicle {
	    @Override
	    public void start() {
	    	System.out.println("Car starting...");
	    }
	    // fuel() can be overridden, but not mandatory
}
