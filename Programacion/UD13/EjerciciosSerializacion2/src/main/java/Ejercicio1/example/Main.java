package Ejercicio1.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path ruta = Path.of("src/main/java/Ejercicio1/example/book.json");
        File archivo = ruta.toFile();

        Book book = new Book("Popeye", "Andres Stan", 1974);
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            String json = objectMapper.writeValueAsString(book);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
