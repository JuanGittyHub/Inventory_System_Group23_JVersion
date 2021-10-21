/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.ac.cput.DBConnection.DBConnection;
import za.ac.cput.Products.Products;

/**
 *
 * @author Juan
 */
public class ProductDAO {
    
    private final Connection con;
    
    public ProductDAO() throws SQLException{
        this.con = DBConnection.DerbeyConnection();
    }
    
    public Products save(Products product) throws SQLException{
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
    
    public void closeResources() throws SQLException{
        this.con.close();
    }
}
