import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

        // Objetivo: Almacenar las palabras de una frase en un tree map y contar cuentas veces aparece cada una.
        Path ruta = Path.of("src/media/texto.txt");
        File archivo = ruta.toFile();
        Pattern patron = Pattern.compile("\\b\\w+\\b");

        TreeMap<String, Long> contadorPalabras = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = reader.readLine()) != null){
                Matcher matcher = patron.matcher(line);

                while (matcher.find()){
                    System.out.println(matcher.group());
                    contadorPalabras.put(matcher.group(), contadorPalabras.containsKey(matcher.group()) ? contadorPalabras.get(matcher.group()) + 1 : 1);
                }


            }

        }

        System.out.println(contadorPalabras);









    }
}
