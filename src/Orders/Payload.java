package Orders;

import Menus.Item;

public class Payload implements Comparable<Payload>{
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

    @Override
    public int compareTo(Payload p){
        if(this.item.getPrice() * this.quantity > p.item.getPrice() * p.quantity)
            return 1;
        if(this.item.getPrice() * this.quantity < p.item.getPrice() * p.quantity)
            return -1;
        return 0;
    }

}
