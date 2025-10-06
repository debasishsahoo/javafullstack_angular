package DBConnQ6;

public interface SessionManageable {
	void startSession();
    void endSession();
    boolean isSessionActive();
    void setSessionTimeout(int minutes);
}
