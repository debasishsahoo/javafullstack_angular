package DiamondProblem;

// This would cause the diamond problem if Java allowed it
//Which version of print() should be inherited? B's or C's?
class D extends B, C {
	@Override
	public void print() {
        System.out.println("Class D");
    }
	 // This class would inherit from both B and C, which both override A's print() method
    // Creating ambiguity about which print() method to use
}
