package Hybrid_Inheritance;

public interface AutonomousDriving {
	void enableAutopilot();
	void calibrateSensors();

	default void safetyCheck() {
		System.out.println("Performing autonomous system safety check");
	}
}
