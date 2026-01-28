import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio3 {
    public static void main(String[] args) throws IOException {

        Path baseDir = Paths.get("src\\media\\");


        Path programacion = baseDir.resolve("Programacion.txt");

        if (!Files.exists(baseDir)) {
            Files.createDirectories(baseDir);
            if (!Files.exists(programacion)){
                Files.createFile(programacion);
            }
        }


        // A
        Path programacion1 = baseDir.resolve("Programacion1.txt");
        Path programacion2 = baseDir.resolve("Programacion2.txt");

        try {
            Files.copy(programacion, programacion1);
            Files.copy(programacion, programacion2);
        } catch (Exception e) {
            System.out.println("Error copiando los archivos (A)");
        }

        // B

        Path samples = baseDir.resolve("samples");
        try {
            Files.createDirectory(samples);
        } catch (IOException e){
            System.out.println("Error creando carpeta samples (B)");
        }

        // C
        Path exercises = baseDir.resolve("exercises\\");
        try {
            Files.createDirectory(exercises);
        } catch (IOException e){
            System.out.println("Error creando carpeta exercises (C)");
        }

        // D
        try {
            Files.copy(programacion, samples.resolve("Programacion.txt"));
        } catch (IOException e) {
            System.out.println("Error copiando archivo Programacion a samples (D)");
        }

        // E

        try {
            Files.move(programacion, exercises.resolve("Programacion.txt"));
        } catch (IOException e) {
            System.out.println("Error al mover archivo Programacion a exercises (E)");
        }

        // F

        try {
            Files.move(programacion1, baseDir.resolve("Programacion.txt"));
        } catch (IOException e) {
            System.out.println("Error cambiando el nombre (F)");
        }

        // g

        try {
            Files.delete(programacion2);
        } catch (NoSuchFileException e) {
            System.out.println("Error, no existe el archivo (G)");
        } catch (IOException e) {
            System.out.println("Error al borrar el archivo (G)");
        }

    }
}
