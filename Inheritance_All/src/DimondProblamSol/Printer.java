package DimondProblamSol;

interface Printer {
	
	 // Abstract method (must be implemented by classes)
	 void print(String document);
	 
	 // Default method (provides default implementation)
	 default void powerOn() {
	        System.out.println("Printer powering on...");
	        warmUp();
	    }
	 
	// Private method (helper method for the interface)
	 private void warmUp() {
	        System.out.println("Printer warming up...");
	    }
	 
	// Static method (belongs to the interface)
	 static void showBrand() {
	        System.out.println("Generic Printer Brand");
	    }
	 
}
