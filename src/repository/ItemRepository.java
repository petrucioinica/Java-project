package repository;

import database.DatabaseConfiguration;
import entities.menus.Item;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class ItemRepository {
    public Item getItemById(int id) {
        String selectSql = "SELECT * FROM items WHERE id=?";
        Connection dbConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Item> getItemsByMenuId(int menuId){
        String queryString = "SELECT * FROM items WHERE menu_id = ?";
        ArrayList<Item> items = new ArrayList<>();
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
            preparedStatement.setDouble(1, menuId);

            ResultSet rs = preparedStatement.executeQuery(queryString);
            while(rs.next()){
                items.add(mapToItem(rs));
            }
            System.out.println("Item updated successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return items;

    }


    public void createItem(int id, double price, String name, int menuId) {
        String addSql = "INSERT INTO items VALUES (?,?,?,null)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(addSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, name);
            //preparedStatement.setInt(4, menuId);
            preparedStatement.executeUpdate();
            System.out.println("Item added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteItem(int id){
        String deleteSql ="DELETE FROM items WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Item deleted successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(int id, double price){
        String updateSql = "UPDATE items SET price = ? WHERE id= ?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateSql);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Item updated successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private Item mapToItem(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Item(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getString(3), resultSet.getInt(4));
        }
        return null;
    }

}
