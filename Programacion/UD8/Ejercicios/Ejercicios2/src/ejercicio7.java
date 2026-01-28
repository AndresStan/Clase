import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio7 {
    static void main(String[] args) {

        Path ejercicio1 = Paths.get("src\\media\\ejercicio1.txt");
        File archivo = ejercicio1.toFile();

        int[] abecedario = new int[26];

        try (FileReader reader = new FileReader(archivo)){

            int byteData;
            while ((byteData = reader.read()) != -1) {

                if (Character.toLowerCase((char) byteData) >= 'a' && (Character.toLowerCase((char) byteData) <= 'z')){

                    int num =  Character.toLowerCase(byteData) - (int) 'a';
                    abecedario[num] += 1;


                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int letra = 97;
        for ( int i : abecedario) {



            System.out.println((char) letra++ + ": "+ i);

        }
    }


}


