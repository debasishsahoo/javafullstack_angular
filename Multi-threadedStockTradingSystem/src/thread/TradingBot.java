package thread;

import model.Stock;
import model.TradeOrder;
import service.PortfolioManager;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class TradingBot extends Thread implements MarketDataListener {
    private final PortfolioManager portfolioManager;
    private final Map<String, Stock> stocks;
    private final String botId;
    private volatile boolean running = true;
    private final Random random = new Random();
    
    public TradingBot(PortfolioManager portfolioManager, Map<String, Stock> stocks) {
        this.portfolioManager = portfolioManager;
        this.stocks = stocks;
        this.botId = "BOT-" + UUID.randomUUID().toString().substring(0, 8);
        setName(botId + "-Thread");
    }
    
    @Override
    public void run() {
        System.out.println(" " + botId + " started trading...");
        
        while (running) {
            try {
                // Make random trading decisions
                Thread.sleep(5000 + random.nextInt(5000));
                makeTradingDecision();
                
            } catch (InterruptedException e) {
                System.out.println(" Trading bot " + botId + " interrupted");
                break;
            }
        }
    }
    
    @Override
    public void onMarketDataUpdate(Map<String, Stock> stocks) {
        // React to market data updates
        if (random.nextDouble() < 0.3) { // 30% chance to react
            makeTradingDecision();
        }
    }
    
    private void makeTradingDecision() {
        if (stocks.isEmpty()) return;
        
        String[] symbols = stocks.keySet().toArray(new String[0]);
        String symbol = symbols[random.nextInt(symbols.length)];
        Stock stock = stocks.get(symbol);
        
        // FIXED: Use getter method instead of reflection
        double currentPrice = stock.getPrice();
        TradeOrder.OrderType type = random.nextBoolean() ? 
            TradeOrder.OrderType.BUY : TradeOrder.OrderType.SELL;
        
        int quantity = 10 + random.nextInt(90); // 10-100 shares
        double orderPrice = currentPrice * (0.98 + random.nextDouble() * 0.04); // ±2% from current
        
        TradeOrder order = new TradeOrder(
            UUID.randomUUID().toString(),
            symbol,
            type,
            quantity,
            orderPrice,
            botId
        );
        
        // Use the simpler version to avoid potential issues
        portfolioManager.submitOrderAsyncSimple(order);
        System.out.printf(" %s placing %s order for %d shares of %s at $%.2f%n", 
            botId, type, quantity, symbol, orderPrice);
    }
    
    public void stopTrading() {
        running = false;
        interrupt();
    }
}