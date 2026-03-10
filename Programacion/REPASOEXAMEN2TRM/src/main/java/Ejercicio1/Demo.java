package Ejercicio1;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    static void main(String[] args) {

        // [ID: 101] Nombre: Juan, Edad: 20, Password: pwd123
        // 1 = id, 2 = nombre, 3 = edad, 4 = contraseña
        Pattern regexID = Pattern.compile("\\[ID: (\\d+)\\] Nombre: (\\w+), Edad: (\\d+), Password: (\\S+)");

       // Creacion de HashMap
        HashMap<Integer, Estudiante> map = new HashMap<>();

        // Creacion de ruta XML

        Path rutaXML = Path.of("src/main/java/Ejercicio1/xml.xml");
        File fileXML = rutaXML.toFile();


        // Creacion de ruta JSON
        Path rutaJSON = Path.of("src/main/java/Ejercicio1/json.json");
        File fileJSON = rutaJSON.toFile();


        // Creacion de ruta ESTUDIANTES
        Path rutaESTUDIANTES = Path.of("src/main/java/Ejercicio1/estudiantes.txt");
        File archivoESTUDIANTES = rutaESTUDIANTES.toFile();


        // Lectura de fichero ESTUDIANTES

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoESTUDIANTES))) {
            String line;
            while ((line = reader.readLine()) != null){
                Matcher matcher = regexID.matcher(line);
                while (matcher.find()){
                   Estudiante estudiante = new Estudiante(Integer.parseInt(matcher.group(1)), matcher.group(2), Integer.parseInt(matcher.group(3)), matcher.group(4));
                   map.put(Integer.parseInt(matcher.group(1)), estudiante);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Ordenar por edad descendente solo los que son mayores de 20
        LinkedHashMap mapaOrdenado = new LinkedHashMap<>();

        map.entrySet().stream().filter(entry -> entry.getValue().getEdad() > 20).sorted(Map.Entry.<Integer, Estudiante>comparingByValue(Comparator.comparingInt(Estudiante::getEdad).reversed()))
                .forEach(entry -> mapaOrdenado.put(entry.getKey(), entry.getValue()));



        // Serializar a JSON

        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter().writeValue(fileJSON, mapaOrdenado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Serializar a XML

        try {
            JAXBContext context = JAXBContext.newInstance(Envoltorio.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Envoltorio envoltorio = new Envoltorio(new ArrayList<>(mapaOrdenado.values()));
            marshaller.marshal(envoltorio, fileXML);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
