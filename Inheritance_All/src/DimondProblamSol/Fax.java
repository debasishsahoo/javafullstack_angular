package DimondProblamSol;

interface Fax extends Printer{
	// Abstract method
    void fax(String document);
    
    // Overriding default method from Printer
    @Override
    default void powerOn() {
        System.out.println("Fax machine powering on...");
        Printer.super.powerOn(); // Calling Printer's default method
    }

}
