package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class Conexion {
    

  static Connection con ;
  
  public static Connection getConexion() throws Exception{
        
        String host = "localhost";
        String user = "root";
        String pass = "root";
        String dtbs = "libreria_utn";
 
        try { 
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            
            con = DriverManager.getConnection(newConnectionURL);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
            return con;
    }
  
   public static void cerrarConexion() throws SQLException{
        try {
                
            con.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
