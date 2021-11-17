package business.entities;

public class OrderEntryCombined {
    private long orderId;
    private int orderCupcakeAmount;
    private double orderPrice;
    private String username;

    public OrderEntryCombined(long orderId, int orderCupcakeAmount, double orderPrice) {
        this.orderId = orderId;
        this.orderCupcakeAmount = orderCupcakeAmount;
        this.orderPrice = orderPrice;
    }

    public OrderEntryCombined(long orderId, int orderCupcakeAmount, double orderPrice, String username) {
        this.orderId = orderId;
        this.orderCupcakeAmount = orderCupcakeAmount;
        this.orderPrice = orderPrice;
        this.username = username;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderCupcakeAmount() {
        return orderCupcakeAmount;
    }

    public void setOrderCupcakeAmount(int orderCupcakeAmount) {
        this.orderCupcakeAmount = orderCupcakeAmount;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
