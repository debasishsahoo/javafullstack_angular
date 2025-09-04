package InheritanceRule;

class Algorithm {
    // Final method - cannot be overridden
    final void criticalProcess() {
        System.out.println("Critical process running");
    }

    void normalProcess() {
        System.out.println("Normal process running");
    }
}

class AdvancedAlgorithm extends Algorithm {
    @Override
    void normalProcess() { //✅ OK: can override non-final method
        System.out.println("Advanced normal process");
    }

    // This would cause error - cannot override final method
     @Override
     void criticalProcess() { } // ❌ ERROR: cannot override final method
}




public class Rule9 {

	public static void main(String[] args) {
		

	}

}
