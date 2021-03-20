package Orders;

import Menus.Item;

public class Payload {
    private Item item;
    private int quantity;

    public Payload(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Payload() {

    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
