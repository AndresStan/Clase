import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ejercicio6 {
    static void main(String[] args) {

        Path ruta = Path.of("src\\media\\ejercicio1.txt");
        File archivo = ruta.toFile();
        int contador = 0;
        try (FileReader reader = new FileReader(archivo)) {

            int byteData;


            while ((byteData = reader.read()) != -1) {

                char caracterActual = (char) byteData;

                if (caracterActual == 'a') {
                    contador = contador + 1;
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            throw new RuntimeException(e);
        }

        System.out.println(contador);
    }
}
