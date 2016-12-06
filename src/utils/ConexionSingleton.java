package utils;


import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConexionSingleton {
 
    
    static Connection con ; 
    private static ConexionSingleton INSTANCE = null;
    
   
    public ConexionSingleton() {
        performConnection();
    }
 
    
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexionSingleton();
        }
    }
 
    
    public static ConexionSingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
 
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
  
    public void performConnection() {
 
        String host = "localhost";
        String user = "root";
        String pass = "root";
        String dtbs = "libreria_utn";
 
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            
            con = DriverManager.getConnection(newConnectionURL);
            
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }
 
   
    public static void closeConnection() {
        try {
                
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
    
    
    public Connection getConexion()
    {   
        return con;
    }
}