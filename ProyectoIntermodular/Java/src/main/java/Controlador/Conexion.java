package Controlador;

import java.io.*;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {

    public static Connection crearConexion() throws SQLException {


        Path ruta = Path.of("src/main/java/Controlador/DatosConexion.txt");
        File archivo = ruta.toFile();
        ArrayList<String> lista = new ArrayList<>();



        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null){
                lista.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = (!lista.isEmpty() && !lista.get(0).isEmpty()) ? lista.get(0) : "jdbc:mysql://localhost:3306/Gimnasio_Andres_Stan";
        String usuario = (lista.size() > 1 && !lista.get(1).isEmpty()) ? lista.get(1) : "root";
        String pass = (lista.size() > 2) ? lista.get(2) : "";

        Connection connection = DriverManager.getConnection(url, usuario, pass);
        System.out.println("Se ha conectado exitosamente a la base de datos");
        return connection;
    }

}
