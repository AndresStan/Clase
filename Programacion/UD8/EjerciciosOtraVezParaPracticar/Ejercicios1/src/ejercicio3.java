import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ejercicio3 {
    public static void main(String[] args) throws IOException {


        Path ruta = Path.of("Documentos\\PRO_UD08_Ej03\\Programacion.txt");
        File archivo = ruta.toFile();

        Files.copy(ruta, Path.of("Documentos\\PRO_UD08_Ej03\\Programacion(+1).txt"));
        Files.copy(ruta, Path.of("Documentos\\PRO_UD08_Ej03\\Programacion(+2.txt"));

        Files.createDirectories(Path.of("Documentos\\PRO_UD08_Ej03\\docs\\samples"));
        Files.createDirectories(Path.of("Documentos\\PRO_UD08_Ej03\\docs\\exercises"));

        Files.copy(ruta, Path.of("Documentos\\PRO_UD08_Ej03\\docs\\samples\\Programacion.txt"));

        Files.move(ruta, Path.of("Documentos\\PRO_UD08_Ej03\\docs\\exercises\\Programacion.txt"));

        Files.move()
    }
}
