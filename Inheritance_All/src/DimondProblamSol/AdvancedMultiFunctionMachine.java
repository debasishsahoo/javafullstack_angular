package DimondProblamSol;

class AdvancedMultiFunctionMachine extends MultiFunctionMachine implements Fax{

	public AdvancedMultiFunctionMachine(String model) {
        super(model);
    }
	
	// Implement Fax's abstract method
	@Override
    public void fax(String document) {
        System.out.println("Faxing: " + document);
    }
	
	
	 // Override powerOn to include fax initialization
	@Override
    public void powerOn() {
        super.powerOn(); // Call the parent's powerOn method
        System.out.println("Initializing fax system...");
    }
}
