package app;

import Orders.Order;
import Users.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//this class is used as a singleton to store the data of the app
public class AppData implements Creations {
    private static ArrayList<User> Users;
    private static ArrayList<Order> Orders;
    private static AppData singleInstance = null;

    private AppData()
    {
        System.out.println("We are creating empty users and orders");
        Users = new ArrayList<User>();
        Orders = new ArrayList<Order>();
    }

    public static AppData appData(){
        if(singleInstance == null){
            singleInstance = new AppData();

        }
        return singleInstance;
    }

    public AppData getInstance(){
        return singleInstance;
    }

    public void end(){
        singleInstance = null;
    }

    public void addUser(){
        System.out.println("Please input the role you want for this user:\n    1: Customer\n   2:Driver\n    3:Restaurant");
        Scanner input = new Scanner(System.in);
        try {

            int command = input.nextInt();
            switch (command) {
                case 1:
                    Client c = generateClient();
                    Users.add(c);
                    break;
                case 2:
                    Driver d = generateDriver();
                    Users.add(d);
                    break;
                case 3:
                    Restaurant r = generateRestaurant();
                    Users.add(r);
                    break;
                default:
                    throw new IOException("Bad input");
            }
        }catch(Exception e){
            System.out.println("ERROR! Returning to actions menu");
        }

    }


}
