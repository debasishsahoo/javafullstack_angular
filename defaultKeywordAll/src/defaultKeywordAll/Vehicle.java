package defaultKeywordAll;

interface Vehicle {
	void start();//Abstract Method
	
	
	
	default void fuel() {
		System.out.println("Default fuel method: Petrol");
	}
	
	
}
