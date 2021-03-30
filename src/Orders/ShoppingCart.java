package Orders;

import java.util.HashSet;

public class ShoppingCart {

    private HashSet<Payload> items;

    public HashSet<Payload> getItems() {
        return items;
    }


    public void setItems(HashSet<Payload> items) {
        this.items = items;
    }

    public ShoppingCart( HashSet<Payload> items) {
        this.items = items;
    }

    public void addPayload(Payload p){
        this.items.add(p);
    }

}
