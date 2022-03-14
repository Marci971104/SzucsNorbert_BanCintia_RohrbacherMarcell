package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private String host;
    private String db;
    private String port;
    private String user;
    private String pass;
    private Connection conn;
    
    public DatabaseConnection() {
        
        host = "127.0.0.1";
        db = "lifestyle";
        port = "8000";
        user = "root";
        pass = "";
        conn = null;
    
    }
    
    
 
       public void setConnection() {
        
        try {
           
            String url = "http://" + host + ":" + port + "/" + db;
            conn = DriverManager.getConnection( url, user, pass );
                
        } catch ( SQLException e ) {
            
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}