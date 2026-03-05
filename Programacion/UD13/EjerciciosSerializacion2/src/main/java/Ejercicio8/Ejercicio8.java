package Ejercicio8;

import Ejercicio8.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio8 {
    public static void main(String[] args) {

        //Creacion de lista de book
        List<Book> miListaLibros = new ArrayList<>();
        miListaLibros.add(new Book("Titanic", "Andres", 1974));
        miListaLibros.add(new Book("Garfield", "Tete", 1988));

        // Creacion de lista de autor
        List<Book> miListaLibrosParaAutor = new ArrayList<>();
        miListaLibrosParaAutor.add(new Book("Titanic", "Andres", 1974));
        miListaLibrosParaAutor.add(new Book("Garfield", "Tete", 1988));
        List<Author> miListaAutor = new ArrayList<>();
        miListaAutor.add(new Author ("Andres",miListaLibrosParaAutor));

        // Creacion de BookStore
        Bookstore miTienda = new Bookstore(miListaLibros, miListaAutor);

        // Creacion de ruta XML
        Path rutaXML = Path.of("src/main/java/Ejercicio8/bookstore.xml");
        File archivoXML = rutaXML.toFile();

        // Creacion de ruta JSON
        Path rutaJSON = Path.of("src/main/java/Ejercicio8/bookstore.json");
        File archivoJSON = rutaJSON.toFile();


        // Serializar usando XML
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(miTienda, archivoXML);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Serializar usando JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(archivoJSON, miTienda);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserializar usando XML
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Bookstore miTiendaXML = (Bookstore) unmarshaller.unmarshal(archivoXML);
            System.out.println(miTiendaXML);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        //Deserializar usando JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            Bookstore miTiendaJSON = (Bookstore) mapper.readValue(archivoJSON, Bookstore.class);
            System.out.println(miTiendaJSON.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
