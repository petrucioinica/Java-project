package app;

import Menus.Item;
import Menus.Menu;
import Orders.Order;
import Orders.Payload;
import Orders.ShoppingCart;
import Users.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public interface Creations {
    default Client generateClient(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the values you want for the added client:\nEmail:");
        String email = input.nextLine();
        System.out.println("First name:");
        String firstName = input.nextLine();
        System.out.println("Last name:");
        String lastName = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        System.out.println("Address:");
        String address = input.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = input.nextLine();
        return new Client(firstName,lastName, Role.CLIENT, email,password,address,phoneNumber);
    }

    default Driver generateDriver(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the values you want for the added driver:\nEmail:");
        String email = input.nextLine();
        System.out.println("First name:");
        String firstName = input.nextLine();
        System.out.println("Last name:");
        String lastName = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        System.out.println("Car number:");
        String carNumber = input.nextLine();
        return new Driver(firstName,lastName, Role.DRIVER, email,password,carNumber);
    }

    default Item generateItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Item name: ");
        String name = input.nextLine();
        System.out.println("Item price: ");
        double price = input.nextDouble();
        return new Item(price,name);
    }

    default Menu generateMenu(int itemsNo){
        Menu m = new Menu();
        for(int i = 0; i < itemsNo; i++){
            System.out.println((i + 1) + ":");
            Item item = generateItem();
            m.addItem(item);
        }
        return m;
    }

    default Restaurant generateRestaurant(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the values you want for the added driver:\nEmail:");
        String email = input.nextLine();
        System.out.println("First name:");
        String firstName = input.nextLine();
        System.out.println("Last name:");
        String lastName = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        System.out.println("Name:");
        String name = input.nextLine();
        System.out.println("Address:");
        String address = input.nextLine();
        System.out.println("Menu items number:");
        Menu m = generateMenu(input.nextInt());
        return new Restaurant(firstName,lastName, Role.RESTAURANT, email,password,name,address,m);
    }

    default Order createOrder(ArrayList<User> users){
        System.out.println("Please select a client for the order (enter the number associated):");
        Scanner input = new Scanner(System.in);
        ArrayList<User> clients = new ArrayList<User>();
        for (User user : users) {
            if(user.getRole() == Role.CLIENT)
                clients.add(user);
        }
        int i = 0;
        for(User user : clients) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        int order = input.nextInt();
        Client client = (Client) clients.get(order);


        System.out.println("Please select a client for the order (enter the number associated):");
        ArrayList<User> drivers = new ArrayList<User>();
        for (User user : users) {
            if(user.getRole() == Role.DRIVER)
                drivers.add(user);
        }
         i = 0;
        for(User user : drivers) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        order = input.nextInt();
        Driver driver =(Driver) drivers.get(order);

        System.out.println("Please select a restaurant for the order (enter the number associated):");
        ArrayList<User> restaurants = new ArrayList<User>();
        for (User user : users) {
            if(user.getRole() == Role.RESTAURANT)
                restaurants.add(user);
        }
        i = 0;
        for(User user : restaurants) {
            System.out.println(i + ":\n" + user.toString());
            i++;
        }
        order = input.nextInt();
        Restaurant restaurant = (Restaurant) restaurants.get(order);

        Boolean isFinalized = false;
        ShoppingCart shoppingCart = new ShoppingCart(new HashSet<>());
        while(!isFinalized) {
            System.out.println("Restaurant menu is: ");
            i = 0;
            for (Item item : restaurant.getMenu().getMenuItems()) {
                System.out.println(i + ": " + item.toString());
                i++;
            }
            System.out.println("-1: Finalize order");
            order = input.nextInt();
            if(order == -1)
                isFinalized = true;
            else{
                System.out.println("Please type in quantity of said item.");
                 int quantity = input.nextInt();
                 shoppingCart.addPayload(new Payload(restaurant.getMenu().getMenuItems().get(order), quantity));
            }
        }

        LocalDateTime dropoffTime =  LocalDateTime.now();
        LocalDateTime pickupTime =  LocalDateTime.parse(dropoffTime.toString()).minusMinutes(30);


        return  new Order(client,driver,restaurant,pickupTime,dropoffTime,shoppingCart);

    }
}
