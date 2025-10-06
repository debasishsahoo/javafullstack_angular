package DBConnQ6;

//Interface for connections supporting connection pooling
public interface ConnectionPoolable {
	void setPoolSize(int size);
    int getPoolSize();
    void returnToPool();
    boolean isFromPool();
}
