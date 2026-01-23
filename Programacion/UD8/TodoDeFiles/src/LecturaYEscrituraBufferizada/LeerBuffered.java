package LecturaYEscritura;

import java.io.*;
import java.nio.file.Path;

public class LeerBuffered {
    public static void main(String[] args) throws FileNotFoundException {

        Path ruta = Path.of("media/LeerBuffered.txt");
        File archivo = ruta.toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            // Se crea una línea porque lee linea a linea
            String line;

            while (( line = reader.readLine()) != null){

                System.out.println(line);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
