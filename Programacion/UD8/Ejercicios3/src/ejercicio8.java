import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejercicio8 {
    public static void main(String[] args) {

        String regex = "\\b[\\w]+\\b";
        Path ruta = Path.of("media/texto.txt");
        File archivo = ruta.toFile();
        StringBuilder texto2 = new StringBuilder();
        Pattern patron = Pattern.compile(regex);

        int contador = 0;

        try (BufferedReader reader = new BufferedReader( new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null){

                Matcher matcher = patron.matcher(linea);
                while (matcher.find())︃{︃
                    contador++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error abriendo el archivo");
        }

        System.out.println(contador);


    }
}
