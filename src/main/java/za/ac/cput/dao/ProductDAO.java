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

    public ArrayList<Notification> getAllProducts()
    {
        ArrayList<Notification> notifications = new ArrayList<Notification>();
        /*String query = ""
                + "SELECT * FROM PROJECT.PRODUCTS WHERE PROJECT.PRODUCTS.QUANTITY <= 5";*/

        String query = ""
                + "SELECT PRODUCTS.\"NAME\", PRODUCTS.QUANTITY "
                + "FROM TRANSACTIONS "
                + "JOIN PRODUCTS ON TRANSACTIONS.PRODUCT = PRODUCTS.BARCODE;";
        try
        {
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                notifications.add(retrieveColumnData(resultSet));
            }
            
        } catch (SQLException exception)
        {
            System.err.println(exception.getMessage());
        }
        return notifications;
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
