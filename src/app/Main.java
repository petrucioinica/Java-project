package app;

import Services.MenusService;
import Services.OrdersService;
import Services.ShoppingCartsService;
import Services.UsersService;
import Users.User;

import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        UsersService usersService = new UsersService();
        OrdersService ordersService = new OrdersService();
        ShoppingCartsService shoppingCartsService = new ShoppingCartsService();
        MenusService menusService = new MenusService();


        System.out.println("APP STARTED\nThe following commands are available:\n");

        boolean programStarted = true;
        while(programStarted){
            Scanner input = new Scanner(System.in);
            System.out.println("MAIN MENU\n0: Exit app\n" +
                    "1: Add user\n" +
                    "2: Get all users\n" +
                    "3: Get users by role\n" +
                    "4: Create order\n" +
                    "5: Get all orders");
            System.out.println("Please enter one of the numbers associated to the above commands.");
            try{
                int command = input.nextInt();
                if(command < 0 || command > 5)
                    throw new java.util.InputMismatchException();
                switch (command){
                    case 0:
                        System.out.println("Exiting..\n");
                        programStarted = false;
                        break;
                    case 1:
                        usersService.addUser();
                        break;
                    case 2:
                        usersService.getAllUsers();
                        break;
                    case 3:
                        usersService.getUsersFiltered();
                        break;
                    case 4:
                        ordersService.addOrder();
                        break;
                    case 5:
                        ordersService.getAllOrders();
                    default:
                        break;
                }
            }
            catch(java.util.InputMismatchException e){
                System.out.println("Please select a valid option");
            }
            catch(Exception e){
                System.out.println(e.toString());
            }


        }

    }
}
