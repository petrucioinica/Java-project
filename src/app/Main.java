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
                    "3: Get users by role\n");
            System.out.println("Please enter one of the numbers associated to the above commands.");
            try{
                int command = input.nextInt();
                if(command < 0 || command > 3)
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
                    default:
                        break;
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
            }


        }

        //add user (role included) DONE
        //list all users DONE
        //list users by role? DONE
        //add items to a restaurant menu DONE
        //create an order
        //add payloads to an order
        //assign driver to an order
        //end order
        //view all orders

    }
}
