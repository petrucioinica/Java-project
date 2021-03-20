package Orders;

import java.time.LocalDateTime;

public class Order {
    private static int count = 0;
    private int id;
    private int clientId;
    private int driverId;
    private int restaurantId;
    private double orderPrice;
    private double fee;
    private LocalDateTime pickupTime;
    private LocalDateTime dropoffTime;
    private OrderStatus status;
    private ShoppingCart boughtItems;

    public Order(int clientId, int driverId, int restaurantId, double orderPrice, double fee, LocalDateTime pickupTime, LocalDateTime dropoffTime, OrderStatus status, ShoppingCart boughtItems) {
        this.id = count + 1;
        setCount(count + 1);
        this.clientId = clientId;
        this.driverId = driverId;
        this.restaurantId = restaurantId;
        this.orderPrice = orderPrice;
        this.fee = fee;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
        this.status = status;
        this.boughtItems = boughtItems;
    }

    public Order() {
        this.id = count + 1;
        setCount(count + 1);

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

    public int getClientId() {
        return clientId;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getRestaurantId() {
        return restaurantId;
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

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
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
}
