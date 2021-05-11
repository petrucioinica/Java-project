package app;

import Services.*;
import Users.User;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        UsersService usersService = new UsersService();
        OrdersService ordersService = new OrdersService();
        ShoppingCartsService shoppingCartsService = new ShoppingCartsService();
        MenusService menusService = new MenusService();
        AuditService auditService = new AuditService();
        UsersService.loadUsers();
        OrdersService.readOrders();


        System.out.println("APP STARTED\nThe following commands are available:\n");

        boolean programStarted = true;
        while (programStarted) {
            Scanner input = new Scanner(System.in);
            System.out.println("MAIN MENU\n0: Exit app\n" +
                    "1: Add user\n" +
                    "2: Get all users\n" +
                    "3: Get users by role\n" +
                    "4: Create order\n" +
                    "5: Get all orders");
            System.out.println("Please enter one of the numbers associated to the above commands.");
            try {
                int command = input.nextInt();
                if (command < 0 || command > 5)
                    throw new java.util.InputMismatchException();
                switch (command) {
                    case 0:
                        System.out.println("Exiting..\n");
                        programStarted = false;
                        break;
                    case 1:
                        usersService.addUser();
                        AuditService.recordAction("Add user");
                        break;
                    case 2:
                        usersService.getAllUsers();
                        AuditService.recordAction("Get all users");
                        break;
                    case 3:
                        AuditService.recordAction("Get users filtered");
                        usersService.getUsersFiltered();
                        break;
                    case 4:
                        AuditService.recordAction("Add order");
                        ordersService.addOrder();
                        break;
                    case 5:
                        AuditService.recordAction("Get all orders");
                        ordersService.getAllOrders();
                    default:
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please select a valid option");
            } catch (Exception e) {
                System.out.println(e.toString());
            }


        }

    }
}
