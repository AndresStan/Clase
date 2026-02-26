package Ejercicio5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Path;

public class Ejercicio5 {

    public static void main(String[] args) {

        Book libro = new Book();
        libro.setAuthor("Luis");
        libro.setTitle("Garfield");

        Path ruta = Path.of("src/main/java/Ejercicio5/xml.xml");
        File file = ruta.toFile();

        // Serializar
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libro, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Deserializar

        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Book libroDeserializado = (Book) unmarshaller.unmarshal(new StringReader(file.toString()));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
