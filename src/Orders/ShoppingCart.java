package Orders;

import java.util.HashSet;

public class ShoppingCart {
    private int orderId;
    private HashSet<Payload> items;

    public int getOrderId() {
        return orderId;
    }

    public HashSet<Payload> getItems() {
        return items;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setItems(HashSet<Payload> items) {
        this.items = items;
    }

    public ShoppingCart(int orderId, HashSet<Payload> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public ShoppingCart() {
    }
}
