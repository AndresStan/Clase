package Ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;

public class ejercicio2 {
    public static void main(String[] args) throws FileNotFoundException {

        Book book = new Book();
        Path ruta = Path.of("src/main/java/Ejercicio1/example/book.json");
        File archivo = ruta.toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = reader.readLine()) != null){

                ObjectMapper objectMapper = new ObjectMapper();
                book = objectMapper.readValue(line, Book.class);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(book.getAuthor());
    }
}
