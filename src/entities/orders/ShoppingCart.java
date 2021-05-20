package entities.orders;

import java.util.ArrayList;

public class ShoppingCart {
    private static int count = 0;
    private int id;
    private ArrayList<Payload> items;
    private int orderId;

    public ArrayList<Payload> getItems() {
        return items;
    }

    public void setItems(ArrayList<Payload> items) {
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ShoppingCart(ArrayList<Payload> items, int orderId) {
        this.items = items;
        this.id = count + 1;
        setCount(count + 1);
        this.orderId = orderId;
    }

    public ShoppingCart(int id, ArrayList<Payload> items, int orderId) {
        this.items = items;
        this.id = id;
        setCount(count + 1);
        this.orderId = orderId;
    }

    public static void setCount(int count) {
        ShoppingCart.count = count;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public void addPayload(Payload p){
        this.items.add(p);
    }

}
