/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import za.ac.cput.DBConnection.DBConnection;
import za.ac.cput.Notifications.Notification;
import za.ac.cput.Products.Products;

/**
 *
 * @author Juan
 */
public class ProductDAO {

    private final Connection con;
    private final int MINIMUM_QUANTITY = 5;

    public ProductDAO() throws SQLException
    {
        this.con = DBConnection.DerbeyConnection();
    }

    public Products save(Products product) throws SQLException
    {
        String insertSQL = "INSERT INTO Products(Name, Price, Quantity, Barcode)" + "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = this.con.prepareStatement(insertSQL);
        ps.setString(1, product.getProductName());
        ps.setDouble(2, product.getProductPrice());
        ps.setInt(3, product.getProductQuantity());
        ps.setString(4, product.getProductBarcode());

        ps.executeUpdate();
        ps.close();
        return product;
    }

    public void saveTransaction(String productBarcode)
    {
        String query = "INSERT INTO TRANSACTIONS (product) VALUES(?)";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            preparedStatement.setString(1, productBarcode);
            preparedStatement.execute();
            reduceQuantity(productBarcode);
            notificationTrigger();
            preparedStatement.close();
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    private void reduceQuantity(String productBarcode)
    {
        int quantity = 0;
        String queryOne = "SELECT PRODUCTS.QUANTITY FROM PRODUCTS WHERE PRODUCTS.BARCODE = ?";
        String queryTwo = "UPDATE PRODUCTS SET PRODUCTS.QUANTITY = ? WHERE PRODUCTS.BARCODE = ?";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(queryOne);
            preparedStatement.setString(1, productBarcode);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next())
            {
                quantity = results.getInt("QUANTITY");
            }
            preparedStatement.close();
            results.close();
            preparedStatement = this.con.prepareStatement(queryTwo);
            --quantity;
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, productBarcode);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    public ArrayList<Notification> getNotifications()
    {
        ArrayList<Notification> notifications = new ArrayList<Notification>();
        /*String query = ""
                + "SELECT * FROM PROJECT.PRODUCTS WHERE PROJECT.PRODUCTS.QUANTITY <= 5";*/

        String query = ""
                + "SELECT PRODUCTS.\"NAME\", PRODUCTS.QUANTITY "
                + "FROM NOTIFICATIONS JOIN PRODUCTS ON NOTIFICATIONS.PRODUCT = PRODUCTS.BARCODE";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                notifications.add(retrieveColumnData(resultSet));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
        return notifications;
    }

    private void notificationTrigger()
    {

        String query = "SELECT * FROM PRODUCTS WHERE PRODUCTS.QUANTITY <= ?";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            preparedStatement.setInt(1, MINIMUM_QUANTITY);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next())
            {
                String productBarcode = results.getString("barcode");
                addNotification(productBarcode);
            }
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    private void addNotification(String productNotification)
    {
        String query = "INSERT INTO PROJECT.NOTIFICATIONS (product) VALUES (?)";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            preparedStatement.setString(1, productNotification);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    private Notification retrieveColumnData(ResultSet resultSet) throws SQLException
    {
        String productName = "";
        int stockLevel = 0;

        productName = resultSet.getString("name");
        stockLevel = resultSet.getInt("quantity");
        return new Notification(productName, stockLevel);
    }

    public void closeResources() throws SQLException
    {
        this.con.close();
    }

}
