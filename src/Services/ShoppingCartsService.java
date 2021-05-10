package Services;

import Menus.Item;
import Orders.Order;
import Orders.Payload;
import Orders.ShoppingCart;
import Users.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ShoppingCartsService {
    public static ShoppingCart createShoppingCart(Restaurant restaurant){
        int i;
        Scanner input = new Scanner(System.in);
        boolean isFinalized = false;
        ShoppingCart shoppingCart = new ShoppingCart(new HashSet<>());
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
                shoppingCart.addPayload(new Payload(restaurant.getMenu().getMenuItems().get(order), quantity));
            }
        }
        return shoppingCart;
    }

    public void getAllOrders(ArrayList<Order> orders){
        for(Order order : orders)
            System.out.println(order.toString() + "\n");
    }
}
