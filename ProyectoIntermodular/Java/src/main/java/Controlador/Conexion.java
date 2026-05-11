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
        Connection connection = DriverManager.getConnection(lista.get(0), lista.get(1), lista.get(2));

        System.out.println("Se ha conectado exitosamente a la base de datos");
        return connection;
    }

}
