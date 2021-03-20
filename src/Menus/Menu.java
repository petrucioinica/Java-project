package Menus;

import java.util.Set;

public class Menu {
    private static int count = 0;
    private int id;
    private Set<Item> MenuItems;

    public Menu() {
        this.id = count + 1;
        setCount(count + 1);

    }

    public Menu(Set<Item> menuItems) {
        this.id = count + 1;
        setCount(count + 1);
        this.MenuItems = menuItems;
    }


    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Set<Item> getMenuItems() {
        return MenuItems;
    }

    public static void setCount(int count) {
        Menu.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMenuItems(Set<Item> menuItems) {
        MenuItems = menuItems;
    }
}
