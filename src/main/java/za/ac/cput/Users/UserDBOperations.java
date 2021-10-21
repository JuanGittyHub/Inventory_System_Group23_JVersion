/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import za.ac.cput.DBConnection.DBConnection;

/**
 *
 * @author Mbuso Kotob's
 */
public class UserDBOperations {
    
    public User getUser(int ID)
    {
        User requestedUser = new User();
        ArrayList<User> users = getUsers();
        for(User user : users)
        {
            if(user.getId() == ID)
            {
                requestedUser = new User(user);
                break;
            }
        }
        return requestedUser;
    }
    
    public User getUser(String email)
    {
        User requestedUser = new User();
        ArrayList<User> users = getUsers();
        for(User user : users)
        {
            String dbEmail = user.getEmail();
            if(email.equalsIgnoreCase(dbEmail))
            {
                requestedUser = new User(user);
                break;
            }
        }    

        return requestedUser.getEmail().equals("") ? null : requestedUser;
    }
    
    public ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM PROJECT.IVNSYS_USER";
        try{
            Connection conn = DBConnection.DerbeyConnection();
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            
            while(results.next())
            {
                this.id = results.getInt("user_id");
                this.firstName = results.getString("user_firstName");
                this.lastName = results.getString("user_lastName");
                this.email = results.getString("user_email");
                this.cellphone = results.getString("user_cellphone");
                this.userType = results.getString("user_type");
                this.password = results.getString("user_password");
                
                users.add(new User(this.id, this.firstName, this.lastName, this.email, this.cellphone, this.userType, this.password));
            }
            results.close(); 
            statement.close();
        }catch(Exception exception)
        {
            System.err.print(exception);
        }
        
        return users;
    }
    
    public int removeUser(int ID)
    {
        int result = 0;
        String query = "DELETE FROM PROJECT.IVNSYS_USER WHERE USER_ID = " + String.valueOf(ID);
        
        try{
            Connection conn = DBConnection.DerbeyConnection();
            Statement statement = conn.createStatement();
            result = statement.executeUpdate(query);
            statement.close();
        }catch(Exception exception)
        {
            System.err.print(exception);
        }
        
        return result;
    }
    
    public void updateUser(User user)
    {
        String query = "UPDATE PROJECT.IVNSYS_USER " + 
                       "SET user_id = ?, user_firstname = ?, user_lastname = ?, " + 
                       "user_email = ?, user_cellphone = ?, user_type = ?, user_password = ? " + 
                       "WHERE USER_ID = " + String.valueOf(user.getId());
        
        try{
            Connection conn = DBConnection.DerbeyConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            initVars(user);
            configureStatementValues(statement);
            statement.executeUpdate();
            statement.close();
        }catch(Exception exception)
        {
            System.err.print(exception);
        }
    }
    
    private void configureStatementValues(PreparedStatement statement) throws SQLException
    {
        statement.setInt(1, this.id);
        statement.setString(2, this.firstName);
        statement.setString(3, this.lastName);
        statement.setString(4, this.email);
        statement.setString(5, this.cellphone);
        statement.setString(6, this.userType);
        statement.setString(7, this.password);
    }
    
    private void initVars(User user)
    {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.cellphone = user.getCellphone();
        this.userType = user.getUserType();
        this.password = user.getPassword();
    }
    
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String cellphone = "";
    private String userType = "";
    private String password = "";
}
