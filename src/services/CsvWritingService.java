package services;
import entities.menus.Item;
import entities.menus.Menu;
import entities.orders.Order;
import entities.orders.Payload;
import entities.orders.ShoppingCart;
import entities.users.Client;
import entities.users.Driver;
import entities.users.Restaurant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvWritingService {
    private static CsvWritingService INSTANCE = null;

    private CsvWritingService(){

    }

    public static synchronized CsvWritingService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CsvWritingService();
        }
        return INSTANCE;
    }

    public static void writeClient(Client user) {
        try {
            File csvFile = new File("./resources/clients.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/clients.csv"));
            FileWriter fw = new FileWriter("./resources/clients.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, entities.orders, role, password, address, phone number\n";
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
            File csvFile = new File("./resources/drivers.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/drivers.csv"));
            FileWriter fw = new FileWriter("./resources/drivers.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, entities.orders, role, password, rating, car number\n";
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
            File csvFile = new File("./resources/items.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/items.csv"));
            FileWriter fw = new FileWriter("./resources/items.csv", true);
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
            File csvFile = new File("./resources/menus.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/menus.csv"));
            FileWriter fw = new FileWriter("./resources/menus.csv", true);
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
            File csvFile = new File("./resources/restaurants.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/restaurants.csv"));
            FileWriter fw = new FileWriter("./resources/restaurants.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "id, email, first name, last name, entities.orders, role, password, name, address, rating\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(restaurant.getId() + "," + restaurant.getEmail() + "," + restaurant.getFirstName() + "," + restaurant.getLastName() + "," +
                    restaurant.getOrders() + "," + restaurant.getRole() + "," + restaurant.getPassword() + "," + restaurant.getName() + "," +
                    restaurant.getAddress() + "," + restaurant.getRating() + " \n"
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
            File csvFile = new File("./resources/payloads.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/payloads.csv"));
            FileWriter fw = new FileWriter("./resources/payloads.csv", true);
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
            File csvFile = new File("./resources/shoppingCarts.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/shoppingCarts.csv"));
            FileWriter fw = new FileWriter("./resources/shoppingCarts.csv", true);
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
            File csvFile = new File("./resources/orders.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/orders.csv"));
            FileWriter fw = new FileWriter("./resources/orders.csv", true);
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
