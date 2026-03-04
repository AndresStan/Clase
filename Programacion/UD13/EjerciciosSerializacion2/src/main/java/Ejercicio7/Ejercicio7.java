package Ejercicio7;

import Ejercicio7.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio7 {
    public static void main(String[] args) {

        // Creacion de Author

        List<Book> listaLibros = new ArrayList<>();

        listaLibros.add(new Book("Titanic", "Andres", 1974));
        listaLibros.add(new Book("Garfield", "Tete", 1988));
        Author autor = new Author("Andres",listaLibros);

        // Creacion de ruta XML
        Path rutaXML = Path.of("src/main/java/Ejercicio7/author.xml");
        File archivoXML = rutaXML.toFile();

        // Creacion de ruta JSON
        Path rutaJSON = Path.of("src/main/java/Ejercicio7/author.json");
        File archivoJSON = rutaJSON.toFile();

      /*  //Serializacion a XML
        try {
            JAXBContext context = JAXBContext.newInstance(Author.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(autor, archivoXML);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
*/
        // Deserializacion de XML

        try {
            JAXBContext context = JAXBContext.newInstance(Author.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Author miNuevoAutor = (Author) unmarshaller.unmarshal(archivoXML);
            System.out.println(miNuevoAutor.getName());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Serializacion a JSON

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJSON))) {
            ObjectMapper objectMapper = new ObjectMapper();
            writer.write(objectMapper.writeValueAsString(autor));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Deserializacion de JSON

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Author autorJSON = objectMapper.readValue(archivoJSON, Author.class);

            autorJSON.getLibros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}









