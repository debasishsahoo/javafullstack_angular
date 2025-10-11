package Mistakes.Mistake2;

public class GoodPoint {
	private int x;
    private int y;
    
    public int getX() { return x; }
    public void setX(int x) {
        if (x < 0) throw new IllegalArgumentException("X must be non-negative");
        this.x = x;
    }
}
