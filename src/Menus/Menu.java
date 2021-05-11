package Menus;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Menu {
    private static int count = 0;
    private int id;
    private int restaurantId;
    private ArrayList<Item> menuItems;

    public Menu(int restaurantId) {
        this.id = count + 1;
        setCount(count + 1);
        this.menuItems = new ArrayList<Item>();
        this.restaurantId = restaurantId;

    }

    public Menu(ArrayList<Item> menuItems,int restaurantId) {
        this.id = count + 1;
        setCount(count + 1);
        this.menuItems = menuItems;
        this.restaurantId = restaurantId;
    }

    public Menu(int id, ArrayList<Item> menuItems,int restaurantId) {
        this.id = id;
        setCount(count + 1);
        this.menuItems = menuItems;
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Item> getMenuItems() {
        return menuItems;
    }

    public static void setCount(int count) {
        Menu.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMenuItems(ArrayList<Item> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(Item i){
        this.menuItems.add(i);
    }
}
