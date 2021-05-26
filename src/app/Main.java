package app;

import database.DataSetup;
import entities.menus.Menu;
import repository.ItemRepository;
import services.*;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        UsersService usersService = UsersService.getInstance();
        OrdersService ordersService = OrdersService.getInstance();
        ShoppingCartsService shoppingCartsService = ShoppingCartsService.getInstance();
        MenusService menusService = MenusService.getInstance();
        AuditService auditService = AuditService.getInstance();
        UsersService.loadUsers();
        OrdersService.readOrders();
        DataSetup setUpData = new DataSetup();

        setUpData.setUp();
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("APP STARTED\nThe following commands are available:\n");

        boolean programStarted = true;

        int menuChosen = 0;
        while (menuChosen == 0) {
            System.out.println("Please select what menu you wish to operate.\n1. Step 1 & step 2\n2. Step 3\n");
            try {
                int command = input.nextInt();
                if (command < 1 || command > 2) {
                    throw new java.util.InputMismatchException();
                }
                switch (command) {
                    case 1:
                        menuChosen = 1;
                        break;
                    case 2:
                        menuChosen = 2;
                        break;
                    default:
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please select a valid option");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        while (programStarted) {
            if (menuChosen == 1) {

                System.out.println("MAIN MENU\n0: Exit app\n" +
                        "1: Add user\n" +
                        "2: Get all users\n" +
                        "3: Get users by role\n" +
                        "4: Create order\n" +
                        "5: Get all orders \n" +
                        "6: Get most expensive item \n" +
                        "7: Get cheapest item \n" +
                        "8: Get most bought item \n" +
                        "9: Get restaurant with most items \n" +
                        "10: Get restaurant with most expensive menu \n");
                System.out.println("Please enter one of the numbers associated to the above commands.");
                try {
                    int command = input.nextInt();
                    if (command < 0 || command > 10)
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
                            break;
                        case 6:
                            MenusService.getExtremeItem("expensive");
                            AuditService.recordAction("Get most expensive item");
                            break;
                        case 7:
                            MenusService.getExtremeItem("cheapest");
                            AuditService.recordAction("Get cheapest item");
                            break;
                        case 8:
                            OrdersService.getMostBoughtItem();
                            AuditService.recordAction("Get most bought item");
                            break;
                        case 9:
                            UsersService.getRestWithMostItems();
                            AuditService.recordAction("Get restaurant with most items");
                            break;
                        case 10:
                            UsersService.getMostExpensiveRestaurant();
                            AuditService.recordAction("Get restaurant with most expensive menu");
                            break;
                        default:
                            break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please select a valid option");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("MAIN MENU\n0: Exit app\n" +
                        "1: Get item by id\n" +
                        "2: Create item\n" +
                        "3: Delete item\n" +
                        "4: Update item\n" +
                        "Please enter one of the numbers associated to the above commands.");
                int command = input.nextInt();

                if (command < 0 || command > 10)
                    throw new java.util.InputMismatchException();
                switch (command) {
                    case 0:
                        programStarted = false;
                        break;
                    case 1:
                        MenusService.getItemById();
                        break;
                    case 2:
                        MenusService.createItem();
                        break;
                    case 3:
                        MenusService.deleteItem();
                        break;
                    case 4:
                        MenusService.updateItem();
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
