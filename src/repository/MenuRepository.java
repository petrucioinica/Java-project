package repository;

import database.DatabaseConfiguration;
import entities.menus.Item;
import entities.menus.Menu;

import java.sql.*;
import java.util.ArrayList;

public class MenuRepository {

    public void createMenu(int id, ArrayList<Item> items, int restaurantId){
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        String createMenuSql = "INSERT INTO menus VALUES (?,?)";
        try {

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(createMenuSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, restaurantId);;
            preparedStatement.executeUpdate();
            ItemRepository ir = new ItemRepository();

            items.forEach(item -> {
                ir.createItem(item.getId(), item.getPrice(), item.getName(), id);
            });
            System.out.println("Menu added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private Menu mapToMenu(ResultSet resultSet) throws SQLException {
       int id, restaurantId;
       ItemRepository ir = new ItemRepository();
        ArrayList<Item> items = new ArrayList<>();
        id = resultSet.getInt(1);
        restaurantId = resultSet.getInt(2);
        items = ir.getItemsByMenuId(id);
        return new Menu(id,items,restaurantId);

    }

}
