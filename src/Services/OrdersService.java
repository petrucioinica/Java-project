package Services;

import Orders.Order;
import Orders.OrderStatus;
import Orders.ShoppingCart;
import Users.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdersService {

    private static ArrayList<Order> orders = new ArrayList<>();

    public void addOrder() {
        ArrayList<User> users = UsersService.getUsers();
        System.out.println("Please select a client for the order (enter the number associated):");
        Scanner input = new Scanner(System.in);
        ArrayList<User> clients = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == Role.CLIENT)
                clients.add(user);
        }
        int i = 0;
        for (User user : clients) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        int order = input.nextInt();
        Client client = (Client) clients.get(order);


        System.out.println("Please select a client for the order (enter the number associated):");
        ArrayList<User> drivers = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == Role.DRIVER)
                drivers.add(user);
        }
        i = 0;
        for (User user : drivers) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        order = input.nextInt();
        Driver driver = (Driver) drivers.get(order);

        System.out.println("Please select a restaurant for the order (enter the number associated):");
        ArrayList<User> restaurants = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == Role.RESTAURANT)
                restaurants.add(user);
        }
        i = 0;
        for (User user : restaurants) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        order = input.nextInt();
        Order o = new Order();
        Restaurant restaurant = (Restaurant) restaurants.get(order);
        ShoppingCart shoppingCart = ShoppingCartsService.createShoppingCart(restaurant, o.getId());
        LocalDateTime dropoffTime = LocalDateTime.now();
        LocalDateTime pickupTime = LocalDateTime.parse(dropoffTime.toString()).minusMinutes(30);
        o.setDriver(driver);
        o.setClient(client);
        o.setRestaurant(restaurant);
        o.setPickupTime(pickupTime);
        o.setDropoffTime(dropoffTime);
        o.setBoughtItems(shoppingCart);
        o.setStatus(OrderStatus.COMPLETED);
        o.setOrderPrice(o.calculatePrice());
        CsvWritingService.writeOrder(o);
        orders.add(o);
    }

    public void getAllOrders() {
        for (Order order : orders)
            System.out.println(order.toString() + "\n");
    }


    public static void readOrders() {
        ArrayList<Order> ro = CsvReadingService.readOrders();
        orders = ro;
    }

}

