/**
 * 
 * GraduateStudent class demonstrating inheritance and method overriding
 * 
 */
public class GraduateStudent extends Student {
	private String researchTopic;
	private String advisor;

	// Constructor using super
	public GraduateStudent(String name, int age, String researchTopic, String advisor) {
		super(name, age); // Call parent constructor
		this.researchTopic = researchTopic;
		this.advisor = advisor;
	}

	// Getter methods for new fields
	public String getResearchTopic() {
		return researchTopic;
	}

	public String getAdvisor() {
		return advisor;
	}
	
	
	
	// 10. METHOD OVERRIDING
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Advisor: " + advisor);
        System.out.println("Student Type: Graduate");
        System.out.println("========================");
    }
    
    @Override
    public String getLetterGrade() {
        double avg = calculateAverage();
        // Graduate students need higher standards
        if (avg >= 95) return "A+";
        else if (avg >= 90) return "A";
        else if (avg >= 85) return "A-";
        else if (avg >= 80) return "B+";
        else if (avg >= 75) return "B";
        else return "Needs Improvement";
    }
	
    @Override
    public boolean isPassing() {
        return calculateAverage() >= 75.0; // Higher passing grade for graduates
    }
	
 // New method specific to graduate students
    public void defendThesis() {
        if (calculateAverage() >= 85.0) {
            System.out.println(getName() + " is ready to defend thesis on: " + researchTopic);
        } else {
            System.out.println(getName() + " needs to improve grades before thesis defense");
        }
    }
	
	

}
