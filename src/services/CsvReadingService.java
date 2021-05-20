package services;

import entities.menus.Item;
import entities.menus.Menu;
import entities.orders.Order;
import entities.orders.Payload;
import entities.orders.ShoppingCart;
import entities.users.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class CsvReadingService {
    public static ArrayList<Client> readClients() {
        try {
            ArrayList<Client> clientsList = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/clients.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");

                Client c = new Client(
                        Integer.parseInt(rowList[0]),
                        Integer.parseInt(rowList[4]),
                        rowList[2],
                        rowList[3],
                        Role.CLIENT,
                        rowList[1],
                        rowList[6],
                        rowList[7],
                        rowList[8]
                );
                clientsList.add(c);

            }
            csvReader.close();
            return clientsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Driver> readDrivers() {
        try {
            ArrayList<Driver> driversList = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/drivers.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                Driver d = new Driver(
                        Integer.parseInt(rowList[0]),
                        Integer.parseInt(rowList[4]),
                        rowList[2],
                        rowList[3],
                        Role.DRIVER,
                        rowList[1],
                        rowList[6],
                        Double.parseDouble(rowList[7]),
                        rowList[8]
                );
                driversList.add(d);

            }
            csvReader.close();
            return driversList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Item> readMenuItems(int menuId) {
        ArrayList<Item> menuItems = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/items.csv"));
            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                if (Integer.parseInt(rowList[3]) == menuId) {
                    Item item = new Item(
                            Integer.parseInt(rowList[0]),
                            Double.parseDouble(rowList[1]),
                            rowList[2],
                            Integer.parseInt(rowList[3])
                    );
                    menuItems.add(item);
                }
            }
            csvReader.close();
            return menuItems;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }


    public static Menu readRestaurantMenu(int restaurantId) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/menus.csv"));

            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                if (Integer.parseInt(rowList[1]) == restaurantId) {
                    ArrayList<Item> menuItems = readMenuItems(Integer.parseInt(rowList[0]));
                    Menu m = new Menu(Integer.parseInt(rowList[0]), menuItems, Integer.parseInt(rowList[1]));
                    csvReader.close();
                    return m;
                }
            }
            csvReader.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Restaurant> readRestaurants() {
        try {
            ArrayList<Restaurant> restaurantsList = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/restaurants.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");

                int restaurantId = Integer.parseInt(rowList[0]);
                Menu m = readRestaurantMenu(restaurantId);
                Restaurant r = new Restaurant(
                        Integer.parseInt(rowList[0]),
                        Integer.parseInt(rowList[4]),
                        Double.parseDouble(rowList[9]),
                        rowList[2],
                        rowList[3],
                        Role.RESTAURANT,
                        rowList[1],
                        rowList[6],
                        rowList[7],
                        rowList[8],
                        m
                );
                restaurantsList.add(r);

            }
            csvReader.close();
            return restaurantsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Restaurant readOrderRestaurant(int restId) {
        final AtomicReference<Restaurant> ref = new AtomicReference<>();
        UsersService.getUsers().forEach(user -> {
            if(user.getId() == restId){
                ref.set((Restaurant) user);

            }
        });
        return ref.get();
    }

    public static Client readOrderClient(int clientId) {
        final AtomicReference<Client> ref = new AtomicReference<>();
        UsersService.getUsers().forEach(user -> {
            if(user.getId() == clientId){
                ref.set((Client) user);
            }
        });
        return ref.get();
    }

    public static Driver readOrderDriver(int driverId) {
        final AtomicReference<Driver> ref = new AtomicReference<>();
        UsersService.getUsers().forEach(user -> {
            if(user.getId() == driverId && user.getRole() == Role.DRIVER){
                ref.set((Driver) user);
            }
        });
        return ref.get();
    }

    public static Item readItemFromPayload(int itemId){
        ArrayList<User> user = UsersService.getUsers();
        final AtomicReference<Item> i = new AtomicReference<>();
        user.forEach(u -> {
            if(u.getRole() == Role.RESTAURANT){
                Restaurant r = (Restaurant) u;
                ArrayList<Item> menuItems = ((Restaurant) u).getMenu().getMenuItems();
                menuItems.forEach(item -> {
                    if(item.getId() == itemId){
                        i.set(item);
                    }
                });

            }
        });
        return i.get();
    }

    public static ArrayList<Payload> readCartPayloads(int cartId) {
        try {
            ArrayList<Payload> readPayloads = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/payloads.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                if (Integer.parseInt(rowList[2]) == cartId) {
                    Item i = readItemFromPayload(Integer.parseInt(rowList[0]));
                    Payload p = new Payload(Integer.parseInt(rowList[0]), i,Integer.parseInt(rowList[1]), Integer.parseInt(rowList[2]));
                    readPayloads.add(p);
                }
            }
            csvReader.close();
            return readPayloads;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ShoppingCart readOrderShoppingCart(int orderId) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/shoppingCarts.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                if (Integer.parseInt(rowList[1]) == orderId) {
                    ArrayList<Payload> payloads = readCartPayloads(Integer.parseInt(rowList[0]));
                    ShoppingCart sc = new ShoppingCart(Integer.parseInt(rowList[0]), payloads, Integer.parseInt(rowList[1]));
                    csvReader.close();
                    return sc;
                }
            }
            csvReader.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Order> readOrders() {
        try {

            ArrayList<Order> orders = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader("./resources/orders.csv"));

            String row = csvReader.readLine(); //reads the header
            while ((row = csvReader.readLine()) != null) {
                String[] rowList = row.split(",");
                Client c = readOrderClient(Integer.parseInt(rowList[1]));
                Driver d = readOrderDriver(Integer.parseInt(rowList[2]));
                Restaurant r = readOrderRestaurant(Integer.parseInt(rowList[3]));
                ShoppingCart sc = readOrderShoppingCart(Integer.parseInt(rowList[0]));

                LocalDateTime puTime = LocalDateTime.parse(rowList[6]);
                LocalDateTime doTime = LocalDateTime.parse(rowList[7]);
                Order o = new Order(Integer.parseInt(rowList[0]), c, d, r, puTime, doTime, sc);
                orders.add(o);

            }

            csvReader.close();
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

