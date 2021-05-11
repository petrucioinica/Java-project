package Orders;

import Menus.Item;

public class Payload implements Comparable<Payload>{
    private Item item;
    private int quantity;
    private int id;
    private int shoppingCartId;
    private static int count = 0;

    public Payload(Item item, int quantity, int shoppingCartId) {
        this.item = item;
        this.quantity = quantity;
        this.shoppingCartId = shoppingCartId;
        this.id = count + 1;
        setCount(count + 1);

    }

    public int getId() {
        return id;
    }

    public Payload() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Payload.count = count;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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
