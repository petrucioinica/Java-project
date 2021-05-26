package database;

import repository.RepositoryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSetup {

    public void setUp() {
        String createRolesSql = "CREATE TABLE IF NOT EXISTS roles" +
                " (id int, role_name varchar(30), PRIMARY KEY (id))";

        String addRolesSql = "INSERT INTO roles (id, role_name) VALUES (1, 'CLIENT'), (2, 'DRIVER'), (3, 'RESTAURANT') ON DUPLICATE KEY UPDATE role_name = role_name";

        String createUsersSql = "CREATE TABLE IF NOT EXISTS users " +
                " (id int, first_name varchar(30), last_name varchar(30), orders int, role_id int, password varchar(30), email varchar(30), " +
                " PRIMARY KEY (id), FOREIGN KEY (role_id) REFERENCES roles(id))";

        String createClientsSql = "CREATE TABLE IF NOT EXISTS clients " +
                "(user_id int, address varchar(30), phone_number varchar(30), " +
                "FOREIGN KEY (user_id) REFERENCES users(id))";


        String createRestaurantSql = "CREATE TABLE IF NOT EXISTS restaurants " +
                "(user_id int, address varchar(30), phone_number varchar(30), " +
                "FOREIGN KEY (user_id) REFERENCES users(id))";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        String createDriversSql = "CREATE TABLE IF NOT EXISTS drivers " +
                "(user_id int, car_number varchar(30), rating float, " +
                "FOREIGN KEY (user_id) REFERENCES users(id))";

        String createMenusSql = "CREATE TABLE IF NOT EXISTS menus " +
                "(id int, restaurant_id int, PRIMARY KEY (id), FOREIGN KEY (restaurant_id) REFERENCES users(id))";

        String createItemsSql = "CREATE TABLE IF NOT EXISTS items " +
                "(id int, price float, name varchar(30), menu_id int, " +
                "PRIMARY KEY (id), FOREIGN KEY (menu_id) REFERENCES menus(id))";





        try {
            repositoryHelper.executeSql(databaseConnection, createRolesSql);
            repositoryHelper.executeSql(databaseConnection, addRolesSql);
            repositoryHelper.executeSql(databaseConnection, createUsersSql);
            repositoryHelper.executeSql(databaseConnection, createClientsSql);
            repositoryHelper.executeSql(databaseConnection, createDriversSql);
            repositoryHelper.executeSql(databaseConnection, createRestaurantSql);
            repositoryHelper.executeSql(databaseConnection, createMenusSql);
            repositoryHelper.executeSql(databaseConnection, createItemsSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}