import java.io.*;
import java.nio.file.Path;

public class Ejercicio6 {
    public static void main(String[] args) throws FileNotFoundException {
        Path ruta = Path.of("media/ejercicio6.txt");
        File archivo = ruta.toFile();
        int contador = 0;
        try (FileReader reader = new FileReader(archivo)) {
            int chardata;
            while ((chardata = reader.read()) != -1){
                if ((char) chardata == 'a' || (char) chardata == 'A'){
                    contador++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(contador);
        }
    }
}
