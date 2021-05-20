package entities.menus;

public class Item implements Comparable<Item> {
    private static int count = 0;
    private int id;
    private double price;
    private String name;
    private int menuId;

    public Item() {
        this.id = count + 1;
        setCount(count + 1);
    }

    public Item(double price, String name, int menuId) {
        this.id = count + 1;
        setCount(count + 1);
        this.price = price;
        this.name = name;
        this.menuId = menuId;
    }

    public Item(int id, double price, String name, int menuId) {
        this.id = id;
        setCount(count + 1);
        this.price = price;
        this.name = name;
        this.menuId = menuId;
    }

    public static int getCount() {
        return count;
    }

    public int getMenuId() {
        return menuId;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("\n");
        sb.append("Price: ");
        sb.append(this.price);
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Item i) {
        if (this.price - i.price > 0)
            return 1;
        else if (this.price - i.price < 0)
            return -1;
        return 0;
    }
}
