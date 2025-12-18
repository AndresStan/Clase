import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio4 {
    static void main(String[] args)  {

      Path ejercicio1 = Paths.get("src\\media\\ejercicio1.txt");
      File archivo = ejercicio1.toFile();

    try (FileReader reader = new FileReader(archivo)) {
        int charData;
        while ((charData = reader.read()) != -1){
            System.out.print( (char) charData);

        }

    } catch (FileNotFoundException e) {
        System.out.println("Error Archivo no encontrado");
    } catch (IOException e) {
        System.out.println("Error abriendo el archivo");
    }


    }
}
