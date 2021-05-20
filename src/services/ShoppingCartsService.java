package services;

import entities.menus.Item;
import entities.orders.Order;
import entities.orders.Payload;
import entities.orders.ShoppingCart;
import entities.users.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartsService {


    private static ShoppingCartsService INSTANCE = null;

    private ShoppingCartsService(){
    }

    public static synchronized ShoppingCartsService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ShoppingCartsService();
        }
        return INSTANCE;
    }
    public static ShoppingCart createShoppingCart(Restaurant restaurant, int orderId){
        int i;
        Scanner input = new Scanner(System.in);
        boolean isFinalized = false;
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(), orderId);
        while (!isFinalized) {
            System.out.println("Restaurant menu is: ");
            i = 0;
            for (Item item : restaurant.getMenu().getMenuItems()) {
                System.out.println(i + ": " + item.toString());
                i++;
            }
            System.out.println("-1: Finalize order");
            int order = input.nextInt();
            if (order == -1)
                isFinalized = true;
            else {
                System.out.println("Please type in quantity of said item.");
                int quantity = input.nextInt();
                Payload p = new Payload(restaurant.getMenu().getMenuItems().get(order), quantity, shoppingCart.getId());
                CsvWritingService.writePayload(p);
                shoppingCart.addPayload(p);
            }
        }
        CsvWritingService.writeShoppingCart(shoppingCart);
        return shoppingCart;
    }

    public void getAllOrders(ArrayList<Order> orders){
        for(Order order : orders)
            System.out.println(order.toString() + "\n");
    }
}
