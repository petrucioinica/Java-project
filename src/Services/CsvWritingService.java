package Services;

import Menus.Item;
import Menus.Menu;
import Orders.Order;
import Orders.Payload;
import Orders.ShoppingCart;
import Users.Client;
import Users.Driver;
import Users.Restaurant;
import Users.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvWritingService {
    public static void writeClient(Client user) {
        try {
            File csvFile = new File("./clients.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./clients.csv"));
            FileWriter fw = new FileWriter("./clients.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, orders, role, password, address, phone number\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(user.getId() + "," + user.getEmail() + "," + user.getFirstName() + "," + user.getLastName() + "," +
                    user.getOrders() + "," + user.getRole() + "," + user.getPassword() + "," + user.getAddress() + "," + user.getPhoneNumber() + "\n"
            );
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeDriver(Driver user) {
        try {
            File csvFile = new File("./drivers.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./drivers.csv"));
            FileWriter fw = new FileWriter("./drivers.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, orders, role, password, rating, car number\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(user.getId() + "," + user.getEmail() + "," + user.getFirstName() + "," + user.getLastName() + "," +
                    user.getOrders() + "," + user.getRole() + "," + user.getPassword() + "," + user.getRating() + "," + user.getCarNumber() + "\n"
            );
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeItem(Item item){
        try {
            File csvFile = new File("./items.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./items.csv"));
            FileWriter fw = new FileWriter("./items.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, price, name, menu id\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(
                    item.getId() + "," + item.getPrice() + "," + item.getName() + "," + item.getMenuId()+ "\n"
            );
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeMenu(Menu menu){
        try {
            File csvFile = new File("./menus.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./menus.csv"));
            FileWriter fw = new FileWriter("./menus.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, restaurant id\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(
                    menu.getId() + "," + menu.getRestaurantId() + "\n"
            );
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeRestaurant(Restaurant restaurant){
        try {
            File csvFile = new File("./restaurants.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./restaurants.csv"));
            FileWriter fw = new FileWriter("./restaurants.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, orders, role, password, name, address, rating\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(restaurant.getId() + "," + restaurant.getEmail() + "," + restaurant.getFirstName() + "," + restaurant.getLastName() + "," +
                    restaurant.getOrders() + "," + restaurant.getRole() + "," + restaurant.getPassword() + "," + restaurant.getName() + "," +
                    restaurant.getAddress() + "," + restaurant.getRating() + "\n"
            );
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writePayload(Payload payload){
        try {
            File csvFile = new File("./payloads.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./payloads.csv"));
            FileWriter fw = new FileWriter("./payloads.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id,quantity,item id, shopping cart id\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(payload.getId() + "," +payload.getQuantity() + "," + payload.getItem().getId() + "," + payload.getShoppingCartId() + "\n");
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeShoppingCart(ShoppingCart sc){
        try {
            File csvFile = new File("./shoppingCarts.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./shoppingCarts.csv"));
            FileWriter fw = new FileWriter("./shoppingCarts.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id,order id\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append( sc.getId() +"," + sc.getOrderId() + "\n");
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeOrder(Order order){
        try {
            File csvFile = new File("./orders.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./orders.csv"));
            FileWriter fw = new FileWriter("./orders.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id,client id, driver id, restaurant id, price, fee, pick up time, drop off time, status\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(order.getId() + "," + order.getClient().getId() + "," + order.getDriver().getId() + "," +
                    order.getRestaurant().getId() +"," +  order.getOrderPrice() + "," + order.getFee() + "," +
                    order.getPickupTime() + "," + order.getDropoffTime() + "," + order.getStatus() + "\n");
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
