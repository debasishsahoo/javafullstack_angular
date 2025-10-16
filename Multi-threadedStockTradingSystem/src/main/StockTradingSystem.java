package main;

import model.Stock;
import model.TradeOrder;
import thread.*;
import service.PortfolioManager;
import java.util.*;
import java.util.concurrent.*;

public class StockTradingSystem {
    private final Map<String, Stock> stocks;
    private final BlockingQueue<TradeOrder> orderQueue;
    private final PortfolioManager portfolioManager;
    private StockPriceSimulator priceSimulator;
    private OrderProcessor orderProcessor;
    private MarketDataPublisher marketDataPublisher;
    private List<TradingBot> tradingBots;
    
    public StockTradingSystem() {
        this.stocks = new ConcurrentHashMap<>();
        this.orderQueue = new LinkedBlockingQueue<>();
        this.portfolioManager = new PortfolioManager(orderQueue);
        this.tradingBots = new ArrayList<>();
        
        initializeStocks();
    }
    
    private void initializeStocks() {
        stocks.put("AAPL", new Stock("AAPL", 150.0));
        stocks.put("GOOGL", new Stock("GOOGL", 2800.0));
        stocks.put("TSLA", new Stock("TSLA", 200.0));
        stocks.put("MSFT", new Stock("MSFT", 300.0));
        stocks.put("AMZN", new Stock("AMZN", 3300.0));
    }
    
    public void startSystem() {
        System.out.println(" Starting Stock Trading System...");
        
        // Start price simulator
        priceSimulator = new StockPriceSimulator(stocks);
        priceSimulator.start();
        
        // Start order processor
        orderProcessor = new OrderProcessor(orderQueue, stocks);
        orderProcessor.start();
        
        // Start market data publisher
        marketDataPublisher = new MarketDataPublisher(stocks);
        
        // Create and register trading bots
        for (int i = 0; i < 3; i++) {
            TradingBot bot = new TradingBot(portfolioManager, stocks);
            marketDataPublisher.addListener(bot);
            tradingBots.add(bot);
            bot.start();
        }
        
        marketDataPublisher.start();
        
        System.out.println(" Trading System Started Successfully!");
        System.out.println(" Active Stocks: " + String.join(", ", stocks.keySet()));
    }
    
    public void stopSystem() {
        System.out.println(" Stopping Stock Trading System...");
        
        // Stop all components
        if (priceSimulator != null) priceSimulator.stopSimulator();
        if (orderProcessor != null) orderProcessor.stopProcessor();
        if (marketDataPublisher != null) marketDataPublisher.stopPublisher();
        
        tradingBots.forEach(TradingBot::stopTrading);
        portfolioManager.shutdown();
        
        // Wait for threads to finish
        try {
            if (priceSimulator != null) priceSimulator.join(3000);
            if (orderProcessor != null) orderProcessor.join(3000);
            if (marketDataPublisher != null) marketDataPublisher.join(3000);
            
            for (TradingBot bot : tradingBots) {
                bot.join(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println(" Trading System Stopped Successfully!");
    }
    
    public void displayMarketData() {
        System.out.println("\n=== LIVE MARKET DATA ===");
        stocks.values().forEach(stock -> 
            System.out.println(stock.getStockInfo()));
        System.out.println("========================\n");
    }
    
    public static void main(String[] args) {
        StockTradingSystem system = new StockTradingSystem();
        system.startSystem();
        
        // Add shutdown hook for graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n🛑 Shutdown hook triggered!");
            system.stopSystem();
        }));
        
        // Display market data periodically
        Timer displayTimer = new Timer(true);
        displayTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                system.displayMarketData();
            }
        }, 0, 10000); // Every 10 seconds
        
        // Let the system run for 1 minute then stop (for demo)
        try {
            Thread.sleep(60000); // 1 minute
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        displayTimer.cancel();
        system.stopSystem();
    }
}