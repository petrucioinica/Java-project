package app;

import Orders.Order;
import Users.Role;
import Users.User;


import java.util.ArrayList;


public interface Interrogations {
    default void getAllUsers(ArrayList<User> users){
            System.out.println("Current users are:");
        for (User user : users) {
                System.out.println(user.toString());
        }
    }

    default void getUsersByRole(ArrayList<User> users, Role role){
        System.out.println("Users with the role of " + role + "are:");
        ArrayList<User> filteredUsers = new ArrayList<User>();
        for (User user : users) {
            if(user.getRole() == role)
                filteredUsers.add(user);
        }
        for(User user : filteredUsers) {
            System.out.println(user.toString());

        }

    }

    default void getAllOrders(ArrayList<Order> orders){
        for(Order order : orders)
            System.out.println(order.toString() + "\n");
    }
}
