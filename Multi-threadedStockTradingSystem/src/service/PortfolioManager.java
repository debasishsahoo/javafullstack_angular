package service;

import model.TradeOrder;
import java.util.concurrent.*;

public class PortfolioManager {
    private final ExecutorService executorService;
    private final BlockingQueue<TradeOrder> orderQueue;
    
    public PortfolioManager(BlockingQueue<TradeOrder> orderQueue) {
        this.orderQueue = orderQueue;
        this.executorService = Executors.newFixedThreadPool(5);
    }
    
    // FIXED: Use Callable instead of lambda without return type
    public Future<String> submitOrderAsync(TradeOrder order) {
        Callable<String> orderTask = new Callable<String>() {
            @Override
            public String call() {
                try {
                    orderQueue.put(order);
                    return String.format("Order %s submitted successfully", order.getOrderId());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return String.format("Failed to submit order %s: %s", 
                                       order.getOrderId(), e.getMessage());
                }
            }
        };
        
        return executorService.submit(orderTask);
    }
    
    // Alternative simpler version using lambda (Java 8+)
    public Future<String> submitOrderAsyncSimple(TradeOrder order) {
        return executorService.submit(() -> {
            try {
                orderQueue.put(order);
                return "Order " + order.getOrderId() + " submitted successfully";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Failed to submit order " + order.getOrderId();
            }
        });
    }
    
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}