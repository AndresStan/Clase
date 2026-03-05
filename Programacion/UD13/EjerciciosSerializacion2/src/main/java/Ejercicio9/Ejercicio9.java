package Ejercicio9;

import Ejercicio9.Book;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    public static void main(String[] args) {

        // Creacion de ruta XML
        Path rutaXML = Path.of("src/main/java/Ejercicio9/publisher.xml");
        File archivoXML = rutaXML.toFile();

        // Creacion de ruta JSON
        Path rutaJSON = Path.of("src/main/java/Ejercicio9/publisher.json");
        File archivoJSON = rutaJSON.toFile();


        List<Book> miListaLibros = new ArrayList<>();
        miListaLibros.add(new Book("Titanic", "Andres", 1974));
        miListaLibros.add(new Book("Garfield", "Tete", 1988));

        Publisher publicador = new Publisher("Andres", "Teruel", miListaLibros);

        // Serializar usando JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoJSON, publicador);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Serializar usando XML
        try {
            JAXBContext context = JAXBContext.newInstance(Publisher.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(publicador, archivoXML);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Deserializar usando JSON3
        try {
            ObjectMapper mapper = new ObjectMapper();
            Publisher publicadorJSON = mapper.readValue(archivoJSON, Publisher.class);
            publicadorJSON.getBooklistMIO();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Deserializar usando XML
        try {
            JAXBContext context = JAXBContext.newInstance(Publisher.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
           // Linea que da error
            // Publisher publicadorXML = (Publisher) unmarshaller.unmarshal(archivoJSON);



        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
