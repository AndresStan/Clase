package Ejercicio4;

import Ejercicio3.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {

        Library libreria = new Library();

        Path ruta = Path.of("src/main/java/Ejercicio3/libreria.json");
        File archivo = ruta.toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            ObjectMapper mapper = new ObjectMapper();
            String line;
            while ((line = reader.readLine()) != null){
              libreria = mapper.readValue(line, Library.class);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(libreria.getLibreria());

    }
}
