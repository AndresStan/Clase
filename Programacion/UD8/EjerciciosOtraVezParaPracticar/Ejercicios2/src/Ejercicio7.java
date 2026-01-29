import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio7 {
    public static void main(String[] args) {

        Path ruta = Path.of("media/ejercicio7.txt");
        File archivo = ruta.toFile();
        boolean seguir = true;
        int mayus = 65;
        int minus = 97;
        int[] abecedario = new int[26];
        int letra = 0;
        while (seguir){
            try (FileReader reader = new FileReader(archivo)) {
                int chardata;
                while ((chardata = reader.read()) != -1){
                    if (chardata == mayus || chardata == minus){
                        abecedario[letra] = abecedario[letra]+1;
                    }
                }
                mayus++;
                minus++;
                letra++;
                if (mayus == 91){
                    seguir = false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        minus = 97;
        for (int e : abecedario){
            System.out.println((char) minus + ": " + e + " ");
            minus++;
        }
    }
}
