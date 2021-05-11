package Services;

import Menus.Item;
import Menus.Menu;

import java.util.Scanner;

public class MenusService {
    public static Item generateItem(Menu m) {
        Scanner input = new Scanner(System.in);
        System.out.println("Item name: ");
        String name = input.nextLine();
        System.out.println("Item price: ");
        double price = input.nextDouble();
        Item i = new Item(price, name, m.getId());
        CsvWritingService.writeItem(i);
        return i;
    }
    public static Menu  generateMenu(int itemsNo, int restaurantId) {
        Menu m = new Menu(restaurantId);
        for (int i = 0; i < itemsNo; i++) {
            System.out.println((i + 1) + ":");
            Item item = generateItem(m);
            m.addItem(item);
        }
        CsvWritingService.writeMenu(m);
        return m;
    }
}
