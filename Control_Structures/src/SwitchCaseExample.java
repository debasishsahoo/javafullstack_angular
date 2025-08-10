
public class SwitchCaseExample {

	public static void main(String[] args) {
		int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }

        System.out.println("Day " + day + " is " + dayName);

        // Enhanced switch (Java 12+)
        char grade = 'B';
        String feedback = switch (grade) {
            case 'A' -> "Excellent work!";
            case 'B' -> "Good job!";
            case 'C' -> "Satisfactory";
            case 'D' -> "Needs improvement";
            case 'F' -> "Failed";
            default -> "Invalid grade";
        };

        System.out.println("Feedback: " + feedback);
	}

}
