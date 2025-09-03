package DimondProblamSol;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Basic Multi-Function Machine ===");
		MultiFunctionMachine basicMachine = new MultiFunctionMachine("OfficeJet 1000");
		basicMachine.showModel();
		basicMachine.powerOn();// Calls the overridden method that resolves the conflict
		basicMachine.print("Quarterly Report");
		basicMachine.scan("Photo");

		System.out.println("\n=== Advanced Multi-Function Machine ===");
		AdvancedMultiFunctionMachine advancedMachine = new AdvancedMultiFunctionMachine("OfficeJet Pro 2000");
		advancedMachine.showModel();
		advancedMachine.powerOn(); // Calls the overridden method in the advanced machine
		advancedMachine.print("Financial Statement");
		advancedMachine.scan("Contract");
		advancedMachine.fax("Signed Agreement");

	}
}
