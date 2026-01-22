package EstudiarMañana;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prueba1 {

    public static void main(String[] args) {

        Path ruta = Path.of("media/prueba1.txt");
        File archivo = ruta.toFile();

        // minimo 1 mayus, 1 caracter especial y 1 numero, minimo 8 caracteres

        Pattern patron = Pattern.compile("(?=\\S*[A-Z])(?=\\S*[^A-Za-z0-9])(?=\\S*[\\d])\\S{8,}");


        try (BufferedReader reader = new BufferedReader( new FileReader( archivo))) {

            String line;


            while ((line = reader.readLine()) != null){

                Matcher matcher = patron.matcher(line);

                while (matcher.find()){
                    System.out.println(matcher.group());
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
