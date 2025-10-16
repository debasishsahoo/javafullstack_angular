package model;

public class TradeOrder {
    public enum OrderType { BUY, SELL }
    public enum Status { PENDING, EXECUTED, CANCELLED }
    
    private final String orderId;
    private final String stockSymbol;
    private final OrderType type;
    private final int quantity;
    private final double price;
    private Status status;
    private final String traderId;
    
    public TradeOrder(String orderId, String stockSymbol, OrderType type, 
                     int quantity, double price, String traderId) {
        this.orderId = orderId;
        this.stockSymbol = stockSymbol;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.traderId = traderId;
        this.status = Status.PENDING;
    }
    
    // ADD THESE GETTER METHODS
    public String getOrderId() { return orderId; }
    public String getStockSymbol() { return stockSymbol; }
    public OrderType getType() { return type; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getTraderId() { return traderId; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    
    @Override
    public String toString() {
        return String.format("Order[%s: %s %d %s @ $%.2f]", 
            orderId, type, quantity, stockSymbol, price);
    }
}