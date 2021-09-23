/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Users;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Mbuso Kotob's
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String userType;
    private String password;
    
    public User()
    {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.cellphone = "";
        this.userType = "";
        this.password = "";
    }

    public User(int id, String firstName, String lastName, String email, String cellphone, String userType, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.userType = userType;
        this.password = password;
    }
    
    public User(User user)
    {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.cellphone = user.cellphone;
        this.userType = user.userType;
        this.password = user.password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCellphone()
    {
        return cellphone;
    }

    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", firstName=" 
                + firstName + ", lastName=" + lastName 
                + ", email=" + email + ", cellphone=" 
                + cellphone + ", userType=" + userType 
                + ", dateAdded=" + '}'
        ;
    }
   
}
