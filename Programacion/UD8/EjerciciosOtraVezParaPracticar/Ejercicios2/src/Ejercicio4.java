import java.io.*;
import java.nio.file.Path;

public class Ejercicio4 {
    public static void main(String[] args) {

        Path ruta = Path.of("media/ejercicio4.txt");
        File archivo = ruta.toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
           String line;

           while ((line = reader.readLine()) != null){

               System.out.println(line);

           }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
