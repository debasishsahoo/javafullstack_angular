package model;

public class Stock {
    private final String symbol;
    private double price;
    private int volume;
    private double high;
    private double low;
    
    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
        this.volume = 0;
        this.high = initialPrice;
        this.low = initialPrice;
    }
    
    // ADD GETTER METHODS
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public int getVolume() { return volume; }
    public double getHigh() { return high; }
    public double getLow() { return low; }
    
    public synchronized void updatePrice(double newPrice) {
        this.price = newPrice;
        this.volume++;
        this.high = Math.max(high, newPrice);
        this.low = Math.min(low, newPrice);
    }
    
    public synchronized String getStockInfo() {
        return String.format("Symbol: %s | Price: $%.2f | Volume: %d | High: $%.2f | Low: $%.2f", 
                           symbol, price, volume, high, low);
    }
}