package thread;

import model.Stock;
import model.TradeOrder;
import java.util.concurrent.BlockingQueue;
import java.util.Map;

public class OrderProcessor extends Thread {
    private final BlockingQueue<TradeOrder> orderQueue;
    private final Map<String, Stock> stocks;
    private volatile boolean running = true;
    
    public OrderProcessor(BlockingQueue<TradeOrder> orderQueue, Map<String, Stock> stocks) {
        this.orderQueue = orderQueue;
        this.stocks = stocks;
        setName("OrderProcessor-Thread");
    }
    
    @Override
    public void run() {
        System.out.println(" Order Processor started...");
        
        while (running || !orderQueue.isEmpty()) {
            try {
                TradeOrder order = orderQueue.take();
                processOrder(order);
                
            } catch (InterruptedException e) {
                System.out.println(" Order processor interrupted");
                break;
            }
        }
    }
    
    private void processOrder(TradeOrder order) {
        Stock stock = stocks.get(order.getStockSymbol());
        if (stock == null) {
            System.out.println(" Invalid stock symbol: " + order.getStockSymbol());
            order.setStatus(TradeOrder.Status.CANCELLED);
            return;
        }
        
        // Simulate order processing time
        try {
            Thread.sleep(500 + (int)(Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        
        order.setStatus(TradeOrder.Status.EXECUTED);
        System.out.printf(" Order %s executed: %s %d shares of %s at $%.2f%n", 
            order.getOrderId(), order.getType(), order.getQuantity(), 
            order.getStockSymbol(), order.getPrice());
    }
    
    public void stopProcessor() {
        running = false;
        interrupt();
    }
}