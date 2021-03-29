package app;

import Users.Role;
import Users.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        for(User user : filteredUsers)
            System.out.println(user.toString());

    }
}
