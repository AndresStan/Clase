package Ejercicio1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {
        Path ruta = Path.of("book.json");
        File archivo = ruta.toFile();

        Book book = new Book("Popeye", "Andres Stan", 1974);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(book);
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
