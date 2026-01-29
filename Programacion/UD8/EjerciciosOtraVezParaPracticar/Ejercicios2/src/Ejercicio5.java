import java.io.*;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void main(String[] args) {

        Path ruta = Path.of("media/ejercicio5a.txt");
        File archivo = ruta.toFile();

        Path ruta2 = Path.of("media/ejercicio5b.txt");
        File archivo2 = ruta2.toFile();

        StringBuilder textoCompleto = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = reader.readLine()) != null){

                textoCompleto.append(line);
                textoCompleto.append("\n");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo2))) {

            writer.write(textoCompleto.toString().toUpperCase());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
