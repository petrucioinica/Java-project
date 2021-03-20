package Menus;

public class Item {
    private static int count = 0;
    private int id;
    private double price;
    private String name;

    public Item() {

    }

    public Item(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static void setCount(int count) {
        Item.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

}
