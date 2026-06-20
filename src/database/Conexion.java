package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0809024"; 

    public static Connection conectar() {
        Connection conexion = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentamos abrir el puente con los datos de arriba
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con MySQL.");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado en las librerías: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos (revisar si Workbench está prendido o la clave): " + e.getMessage());
        }
        return conexion;
    }
}
