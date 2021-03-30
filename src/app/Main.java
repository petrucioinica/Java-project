package app;

import java.io.IOException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        AppData data = AppData.appData();
        System.out.println("APP STARTED\nThe following commands are available:\n");

        while(data.getInstance() != null){
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
                    throw new IOException("Please enter a valid option.\n");
                switch (command){
                    case 0:
                        System.out.println("Exiting..\n");
                        data.end();
                        break;
                    case 1:
                        data.addUser();
                        break;
                    case 2:
                        data.getUsers();
                        break;
                    case 3:
                        data.getUsersFiltered();
                        break;
                    case 4:
                        data.addOrder();
                        break;
                    case 5:
                        data.showAllOrders();
                    default:
                        break;
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
            }


        }

    }
}
