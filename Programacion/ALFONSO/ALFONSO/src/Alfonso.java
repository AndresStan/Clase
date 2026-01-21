import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alfonso {

    static void main(String[] args) {

        Path ruta = Path.of("media/alfonso.txt");
        File archivo = ruta.toFile();

        String regex = "\\|(?i)(?=[^|]*x[^|]*x)(12[0-3]|1[0-1]\\d|[1-9]\\d|\\d).{2,4}\\|";
        Pattern patron = Pattern.compile(regex);


        try (BufferedReader reader = new BufferedReader( new FileReader(archivo))){
            String line;

            while ((line = reader.readLine()) != null){

                Matcher matcher = patron.matcher(line);

                while ( matcher.find())
                {
                    System.out.println(matcher.group());

                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
