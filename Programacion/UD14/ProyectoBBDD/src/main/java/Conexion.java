import java.sql.*;
import java.util.Scanner;

public class Conexion {

    public static Connection crearConexion() throws SQLException {
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_libros", "root", "1234");
         System.out.println("Se ha conectado exitosamente a la base de datos");
         return connection;
    }







}
