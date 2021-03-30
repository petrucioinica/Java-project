package app;

import Orders.Order;
import Users.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//this class is used as a singleton to store the data of the app
public class AppData implements Creations, Interrogations {
    private static ArrayList<User> users;
    private static ArrayList<Order> orders;
    private static AppData singleInstance = null;

    private AppData() {
        System.out.println("We are creating empty users and orders");
        users = new ArrayList<User>();
        orders = new ArrayList<Order>();
    }

    public static AppData appData() {
        if (singleInstance == null) {
            singleInstance = new AppData();

        }
        return singleInstance;
    }

    public AppData getInstance() {
        return singleInstance;
    }

    public void end() {
        singleInstance = null;
    }

    public void addUser() {
        System.out.println("Please input the role you want for this user:\n    1: Customer\n   2:Driver\n    3:Restaurant");
        Scanner input = new Scanner(System.in);
        try {

            int command = input.nextInt();
            switch (command) {
                case 1:
                    Client c = generateClient();
                    users.add(c);
                    break;
                case 2:
                    Driver d = generateDriver();
                    users.add(d);
                    break;
                case 3:
                    Restaurant r = generateRestaurant();
                    users.add(r);
                    break;
                default:
                    throw new IOException("Bad input");
            }
        } catch (Exception e) {
            System.out.println("ERROR! Returning to actions menu");
        }

    }

    public void getUsers() {
        getAllUsers(users);
    }

    public void getUsersFiltered() {
        System.out.println("What role would you like to filter by?\n1: Client\n2: Driver\n3: Restaurant");
        Scanner input = new Scanner(System.in);
        try {
            int command = input.nextInt();
            switch (command) {
                case 1:
                    getUsersByRole(users, Role.CLIENT);
                    break;
                case 2:
                    getUsersByRole(users, Role.DRIVER);
                    break;
                case 3:
                    getUsersByRole(users, Role.RESTAURANT);
                    break;
                default:
                    throw new IOException("Bad input");
            }

        } catch (Exception e) {
            System.out.println("ERROR! Returning to actions menu");
        }
    }

    public void addOrder(){
        try {
            orders.add(createOrder(users));
        }catch (Exception e) {
            System.out.println("ERROR! Returning to actions menu");
        }
    }

    public void showAllOrders(){
        getAllOrders(orders);
    }
}
