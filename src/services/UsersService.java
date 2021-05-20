package services;

import entities.menus.Menu;
import entities.users.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class UsersService {
    private static ArrayList<User> users;

    private static UsersService INSTANCE = null;

    private UsersService(){
      users = new ArrayList<>();
    }

    public static synchronized UsersService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UsersService();
        }
        return INSTANCE;
    }

    public Client generateClient() {
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
        return new Client(firstName, lastName, Role.CLIENT, email, password, address, phoneNumber);
    }

    public Driver generateDriver() {
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
        return new Driver(firstName, lastName, Role.DRIVER, email, password, carNumber);
    }

    public Restaurant generateRestaurant() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the values you want for the added restaurant:\nEmail:");
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
        Restaurant r = new Restaurant();
        Menu m = MenusService.generateMenu(input.nextInt(), r.getId());
        r.setEmail(email);
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setPassword(password);
        r.setName(name);
        r.setAddress(address);
        r.setMenu(m);
        r.setRole(Role.RESTAURANT);
        CsvWritingService.writeRestaurant(r);
        return r;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public void getAllUsers() {
        System.out.println("Current entities.users are:");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public void getUsersByRole(Role role) {
        System.out.println("Users with the role of " + role + "are:");
        ArrayList<User> filteredUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == role)
                filteredUsers.add(user);
        }
        for (User user : filteredUsers) {
            System.out.println(user.toString());

        }
    }

    public void addUser() {
        System.out.println("Please input the role you want for this user:\n    1: Customer\n   2:Driver\n    3:Restaurant");
        Scanner input = new Scanner(System.in);
        try {

            int command = input.nextInt();
            switch (command) {
                case 1:
                    Client c = generateClient();
                    CsvWritingService.writeClient(c);
                    users.add(c);
                    break;
                case 2:
                    Driver d = generateDriver();
                    CsvWritingService.writeDriver(d);
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

    public void getUsersFiltered() {
        System.out.println("What role would you like to filter by?\n1: Client\n2: Driver\n3: Restaurant");
        Scanner input = new Scanner(System.in);
        try {
            int command = input.nextInt();
            switch (command) {
                case 1:
                    getUsersByRole(Role.CLIENT);
                    break;
                case 2:
                    getUsersByRole(Role.DRIVER);
                    break;
                case 3:
                    getUsersByRole(Role.RESTAURANT);
                    break;
                default:
                    throw new IOException("Bad input");
            }

        } catch (Exception e) {
            System.out.println("ERROR! Returning to actions menu");
        }
    }

    public static void loadUsers() {
        ArrayList<Client> clients = CsvReadingService.readClients();
        ArrayList<Driver> drivers = CsvReadingService.readDrivers();
        ArrayList<Restaurant> restaurants = CsvReadingService.readRestaurants();
        ArrayList<User> readUsers = new ArrayList<>();
        readUsers.addAll(clients);
        readUsers.addAll(drivers);
        readUsers.addAll(restaurants);
        users = readUsers;
    }

    public static void getRestWithMostItems(){
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        UsersService.getUsers().forEach(user -> {
            if (user.getRole() == Role.RESTAURANT){
                restaurants.add((Restaurant) user);
            }
        });
        final AtomicReference<Restaurant> maxRest = new AtomicReference<>(null);

        restaurants.forEach(restaurant -> {
            if(maxRest.get() == null || restaurant.getMenu().getMenuItems().size() > maxRest.get().getMenu().getMenuItems().size()){
                maxRest.set(restaurant);
            }
        });

        System.out.println("The restaurant with the most items is " + maxRest.get() + " It has a total of " + maxRest.get().getMenu().getMenuItems().size() + " items.");
    }

    public static void getMostExpensiveRestaurant(){
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        UsersService.getUsers().forEach(user -> {
            if (user.getRole() == Role.RESTAURANT){
                restaurants.add((Restaurant) user);
            }
        });
        final AtomicReference<Restaurant> maxRest = new AtomicReference<>(null);
        AtomicInteger maxValue = new AtomicInteger();

        restaurants.forEach(restaurant -> {
            int restValue = restaurant.getMenu().getMenuItems().stream().mapToInt(item -> (int) item.getPrice()).sum();
            if(restValue > maxValue.get()){
                maxValue.set(restValue);
                maxRest.set(restaurant);
            }
        });

        System.out.println("The restaurant with the most expensive menu is " + maxRest.get() + " Its items have a total price of " + maxValue.get() + ".");

    }

}
