package LecturaYEscritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class EscribirBuffered {
    public static void main(String[] args) {

        String texto = "Esto va a aparecer en el EscribirBuffered";

        Path ruta = Path.of("media/EscribirBuffered.txt");
        File archivo = ruta.toFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {


            writer.write(texto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
