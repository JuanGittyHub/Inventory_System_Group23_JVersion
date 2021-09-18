
package za.ac.cput.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    public static Connection DerbeyConnection() throws SQLException{
        
        String url = "jdbc:derby://localhost:1527/Group23";
        String user = "project";
        String password = "admin";
        
        return(Connection)DriverManager.getConnection(url, user, password);
    }
}
