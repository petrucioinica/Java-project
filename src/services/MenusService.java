package services;

import entities.menus.Item;
import entities.menus.Menu;
import entities.users.Restaurant;
import entities.users.Role;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

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

    public static void getExtremeItem(String comparation){
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        UsersService.getUsers().forEach(user -> {
            if (user.getRole() == Role.RESTAURANT){
                restaurants.add((Restaurant) user);
            }
        });
        final AtomicReference<Item> maxItem = new AtomicReference<>(null);
        restaurants.forEach(restaurant -> {
            restaurant.getMenu().getMenuItems().forEach(item -> {
                if(maxItem.get() == null){
                    maxItem.set(item);
                }
                else{

                    if((maxItem.get().compareTo(item) < 0 && comparation == "expensive") || (comparation == "cheapest" && maxItem.get().compareTo(item) > 0 )){
                        maxItem.set(item);
                    }
                }
            });
        });

        if(comparation == "expensive")
            System.out.println("The most expensive item available is " + maxItem.get());
        else
            System.out.println("The cheapest item available is " + maxItem.get());

    }

}
