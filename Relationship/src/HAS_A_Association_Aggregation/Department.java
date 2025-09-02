package HAS_A_Association_Aggregation;
class Department {
	private String name;
    private Professor prof; // Aggregation: Department HAS-A Professor
    
    // Professor is created elsewhere and passed in
    Department(String name, Professor prof) {
        this.name = name;
        this.prof = prof;
    }
}
