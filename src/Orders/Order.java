package Orders;

import Users.Client;
import Users.Driver;
import Users.Restaurant;

import java.time.LocalDateTime;

public class Order {
    private static int count = 0;
    private int id;
    private Client client;
    private Driver driver;
    private Restaurant restaurant;
    private double orderPrice;
    private double fee;
    private LocalDateTime pickupTime;
    private LocalDateTime dropoffTime;
    private OrderStatus status;
    private ShoppingCart boughtItems;

    public Order(Client client, Driver driver, Restaurant restaurant,LocalDateTime pickupTime, LocalDateTime dropoffTime, ShoppingCart boughtItems) {
        double totalPrice = 0;
        for(Payload payload : boughtItems.getItems()){
            double unitPrice = payload.getItem().getPrice();
            totalPrice+=unitPrice * payload.getQuantity();
        }
        this.id = count + 1;
        setCount(count + 1);
        this.client = client;
        this.driver= driver;
        this.restaurant = restaurant;
        this.orderPrice = totalPrice;
        this.fee = 0;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
        this.status = OrderStatus.COMPLETED;
        this.boughtItems = boughtItems;
    }

    public Order() {
        this.id = count + 1;
        setCount(count + 1);
        this.orderPrice = 0;
        this.fee = 0;


    }

    public ShoppingCart getBoughtItems() {
        return boughtItems;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public double getFee() {
        return fee;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public LocalDateTime getDropoffTime() {
        return dropoffTime;
    }

    public void setBoughtItems(ShoppingCart boughtItems) {
        this.boughtItems = boughtItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void setDropoffTime(LocalDateTime dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(this.id + "\n");
        sb.append("Restaurant: " + this.restaurant.getName() + "\n");
        sb.append("Client: " + this.client.getFirstName() + " " + this.client.getLastName() + "\n");
        sb.append("Driver: " + this.driver.getFirstName() + " " + this.driver.getLastName() + "\n");
        sb.append("Pickup time: " + this.pickupTime.toString() + "\n");
        sb.append("Dropoff time: " + this.dropoffTime.toString() + "\n");
        sb.append("Order cost: " + this.orderPrice + "\nItems:");
        for(Payload payload : this.boughtItems.getItems()){
            sb.append(payload.getItem().getName() + " ... " + payload.getQuantity() + "pieces\n");
        }
        sb.append("\n");
        return sb.toString();

    }
}
