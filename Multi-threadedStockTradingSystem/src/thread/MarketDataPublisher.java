package thread;

import model.Stock;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketDataPublisher extends Thread {
    private final Map<String, Stock> stocks;
    private final CopyOnWriteArrayList<MarketDataListener> listeners;
    private volatile boolean running = true;
    
    public MarketDataPublisher(Map<String, Stock> stocks) {
        this.stocks = stocks;
        this.listeners = new CopyOnWriteArrayList<>();
        setName("MarketDataPublisher-Thread");
    }
    
    @Override
    public void run() {
        System.out.println(" Market Data Publisher started...");
        
        while (running) {
            try {
                Thread.sleep(3000); // Publish every 3 seconds
                
                // Notify all listeners with current market data
                for (MarketDataListener listener : listeners) {
                    listener.onMarketDataUpdate(stocks);
                }
                
            } catch (InterruptedException e) {
                System.out.println(" Market data publisher interrupted");
                break;
            }
        }
    }
    
    public void addListener(MarketDataListener listener) {
        listeners.add(listener);
    }
    
    public void removeListener(MarketDataListener listener) {
        listeners.remove(listener);
    }
    
    public void stopPublisher() {
        running = false;
        interrupt();
    }
}

// Listener Interface
interface MarketDataListener {
    void onMarketDataUpdate(Map<String, Stock> stocks);
}