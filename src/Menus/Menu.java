package Menus;

import java.util.Set;
import java.util.TreeSet;

public class Menu {
    private static int count = 0;
    private int id;
    private TreeSet<Item> menuItems;

    public Menu() {
        this.id = count + 1;
        setCount(count + 1);
        this.menuItems = new TreeSet<Item>();

    }

    public Menu(TreeSet<Item> menuItems) {
        this.id = count + 1;
        setCount(count + 1);
        this.menuItems = menuItems;
    }


    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Set<Item> getMenuItems() {
        return menuItems;
    }

    public static void setCount(int count) {
        Menu.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMenuItems(TreeSet<Item> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(Item i){
        this.menuItems.add(i);
    }
}
