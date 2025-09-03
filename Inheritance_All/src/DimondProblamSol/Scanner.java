package DimondProblamSol;

interface Scanner {
	// Abstract method
    void scan(String document);
    
 // Default method with same name as in Printer
    default void powerOn() {
        System.out.println("Scanner powering on...");
        calibrate();
    }
    
    // Private method
    private void calibrate() {
        System.out.println("Scanner calibrating...");
    }
    
    // Static method
    static void showBrand() {
        System.out.println("Generic Scanner Brand");
    }
    
}
