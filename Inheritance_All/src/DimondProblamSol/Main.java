package DimondProblamSol;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Basic Multi-Function Machine ===");
		 MultiFunctionMachine basicMachine = new MultiFunctionMachine("OfficeJet 1000");
		 basicMachine.showModel();
		 basicMachine.powerOn();
		 basicMachine.print("Quarterly Report");
		 basicMachine.scan("Photo");
		
		
	}
}
