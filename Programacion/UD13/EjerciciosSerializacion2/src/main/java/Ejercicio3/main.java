package Ejercicio3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.nio.file.Path;

public class main {

    public static void main(String[] args) {

        Path ruta = Path.of("src/main/java/Ejercicio3/libreria.json");
        File archivo = ruta.toFile();

        Library libreria = new Library();

        Book book1 = new Book("Garfiel", "Andres Stan", 1974);
        Book book2 = new Book("Titanic", "Luis Stan", 1999);
        Book book3 = new Book("Alter", "Sara Gomez", 2002);


        libreria.setLibro(book1);
        libreria.setLibro(book2);
        libreria.setLibro(book3);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(libreria));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
