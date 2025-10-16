package thread;

import model.Stock;
import java.util.Map;
import java.util.Random;

public class StockPriceSimulator extends Thread {
    private final Map<String, Stock> stocks;
    private volatile boolean running = true;
    private final Random random = new Random();
    
    public StockPriceSimulator(Map<String, Stock> stocks) {
        this.stocks = stocks;
        setName("StockPriceSimulator-Thread");
    }
    
    @Override
    public void run() {
        System.out.println("Stock Price Simulator started...");
        
        while (running) {
            try {
                // Simulate price changes every 2-5 seconds
                Thread.sleep(2000 + random.nextInt(3000));
                
                stocks.forEach((symbol, stock) -> {
                    double currentPrice = getCurrentPrice(stock);
                    double changePercent = (random.nextDouble() - 0.5) * 0.1; // ±5% change
                    double newPrice = currentPrice * (1 + changePercent);
                    
                    synchronized (stock) {
                        stock.updatePrice(newPrice);
                    }
                    
                    System.out.printf("%s: $%.2f → $%.2f (%.2f%%)%n", 
                        symbol, currentPrice, newPrice, changePercent * 100);
                });
                
            } catch (InterruptedException e) {
                System.out.println("Stock simulator interrupted");
                break;
            }
        }
    }
    
    private double getCurrentPrice(Stock stock) {
        // Reflection or getter method to access price
        try {
            java.lang.reflect.Field priceField = Stock.class.getDeclaredField("price");
            priceField.setAccessible(true);
            return priceField.getDouble(stock);
        } catch (Exception e) {
            return 100.0; // Default fallback
        }
    }
    
    public void stopSimulator() {
        running = false;
        interrupt();
    }
}