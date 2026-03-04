package Ejercicio6;

import Ejercicio6.Library;
import Ejercicio6.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;

public class Ejercicio6 {
    public static void main(String[] args) {

        Path ruta = Path.of("src/main/java/Ejercicio6/libreria.xml");
        File archivo = ruta.toFile();


        Book libro1 = new Book();
        libro1.setAuthor("Luis");
        libro1.setTitle("Garfield");
        libro1.setYearPublished(2012);

        Book libro2 = new Book();
        libro2.setAuthor("Andres");
        libro2.setTitle("Titanic");
        libro2.setYearPublished(2018);

        Library libreria = new Library();

        libreria.setLibro(libro1);
        libreria.setLibro(libro2);


        // Serializar
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libreria, archivo);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Deserializar
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Library milibreria = (Library) unmarshaller.unmarshal(archivo);
            milibreria.getLibros();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
