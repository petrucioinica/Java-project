package Orders;

import java.util.Set;

public class ShoppingCart {
    private int orderId;
    private Set<Payload> items;

    public int getOrderId() {
        return orderId;
    }

    public Set<Payload> getItems() {
        return items;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setItems(Set<Payload> items) {
        this.items = items;
    }

    public ShoppingCart(int orderId, Set<Payload> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public ShoppingCart() {
    }
}
