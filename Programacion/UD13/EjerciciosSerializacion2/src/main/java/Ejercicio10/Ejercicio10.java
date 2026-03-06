package Ejercicio10;

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
import java.util.HashMap;
import java.util.List;

public class Ejercicio10 {
    public static void main(String[] args) {

        // Creacion de ruta XML
        Path rutaXML = Path.of("src/main/java/Ejercicio10/catalogo.xml");
        File archivoXML = rutaXML.toFile();

        // Creacion de ruta JSON
        Path rutaJSON = Path.of("src/main/java/Ejercicio10/catalogo.json");
        File archivoJSON = rutaJSON.toFile();

        // Creacion de catalogo

        Book libro1 = new Book("Popeye", "Andres", 1933);
        Book libro2 = new Book("Titanic", "Luis", 2012);
        List<Book> lista = new ArrayList<>();
        lista.add(libro1);
        lista.add(libro2);
        Author autor = new Author("Andres", lista);
        HashMap<Author, Book> map = new HashMap<>();
        map.put(autor, libro1);
        LibraryCatalog miCatalogo = new LibraryCatalog(map);


        // Serializar usando XML
            try {
                JAXBContext context = JAXBContext.newInstance(LibraryCatalog.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(miCatalogo, archivoXML);

            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

        // Serializar usando JSON
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(archivoJSON, miCatalogo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        // Deserializar usando XML
            try {
                JAXBContext context = JAXBContext.newInstance(LibraryCatalog.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                LibraryCatalog libreriaXML = (LibraryCatalog) unmarshaller.unmarshal(archivoXML);
                System.out.println(libreriaXML.getCatalogo().entrySet());

            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

            // Deserializar usando JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            LibraryCatalog libreriaJSON = (LibraryCatalog) mapper.readValue(archivoJSON, LibraryCatalog.class);
            System.out.println(libreriaJSON.getCatalogo().entrySet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
