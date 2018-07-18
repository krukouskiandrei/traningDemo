package by.krukouski.collections;

public class Order {

    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }

    public float getAmount() {
        return amount;
    }

    public Order(int orderId, float amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    private float amount;

}
