import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alfonso {

    static void main(String[] args) {

        Path ruta = Path.of("media/alfonso.txt");
        File archivo = ruta.toFile();

        String regex = "\\b(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\b";
        Pattern patron = Pattern.compile(regex);


        try (BufferedReader reader = new BufferedReader( new FileReader(archivo))){
            String line;

            while ((line = reader.readLine()) != null){

                Matcher matcher = patron.matcher(line);

                while (matcher.find()){

                    System.out.println("IP Valida, dada la vuelta: " + line.replaceAll(regex, "$4.$3.$2.$1"));

                }


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
