package DimondProblamSol;

class MultiFunctionMachine implements Printer, Scanner {
	private String model;

	public MultiFunctionMachine(String model) {
		this.model = model;
	}


	// Implement Printer's abstract method
	@Override
	public void print(String document) {
		System.out.println("Printing: " + document + " on " + model);
	}

	// Implement Scanner's abstract method
	@Override
	public void scan(String document) {
		System.out.println("Scanning: " + document + " on " + model);
	}

	// Resolve the default method conflict between Printer and Scanner
	@Override
	public void powerOn() {
		System.out.println("Multi-function device powering up...");
		Printer.super.powerOn(); // Explicitly call Printer's default method
		Scanner.super.powerOn(); // Explicitly call Scanner's default method
	}

	// Additional method specific to this class
	public void showModel() {
		System.out.println("Device Model: " + model);
	}

}
