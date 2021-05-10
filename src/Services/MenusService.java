package Services;

import Menus.Item;
import Menus.Menu;

import java.util.Scanner;

public class MenusService {
    public static Item generateItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Item name: ");
        String name = input.nextLine();
        System.out.println("Item price: ");
        double price = input.nextDouble();
        return new Item(price, name);
    }
    public static Menu  generateMenu(int itemsNo) {
        Menu m = new Menu();
        for (int i = 0; i < itemsNo; i++) {
            System.out.println((i + 1) + ":");
            Item item = generateItem();
            m.addItem(item);
        }
        return m;
    }
}
