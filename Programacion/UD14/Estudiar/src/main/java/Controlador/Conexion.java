package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection crearConexion () {
        try  {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia" , "root", "");
            System.out.println("Te has conectado correctamente");
           return connection;


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error conectandote a la base da datos");
            throw new RuntimeException(e);
        }


    }

}
