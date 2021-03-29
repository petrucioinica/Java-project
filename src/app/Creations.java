package app;

import Menus.Item;
import Menus.Menu;
import Users.Client;
import Users.Driver;
import Users.Restaurant;
import Users.Role;

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
        System.out.println("Phone number:");
        String carNumber = input.nextLine();
        return new Driver(firstName,lastName, Role.CLIENT, email,password,carNumber);
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
        return new Restaurant(firstName,lastName, Role.CLIENT, email,password,name,address,m);

    }
}
