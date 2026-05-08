package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection crearConexion(){
        try  {
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia" , "root" , "");
            System.out.println(" Te has conectado correctamente a la base de datos");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
