import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio5 {
    static void main(String[] args) throws IOException {

        Path ruta = Paths.get("src\\media\\ejercicio1.txt");
        File archivo = ruta.toFile();

        Path ruta2 = Paths.get("src\\media\\ejercicio2.txt");
        File archivo2 = ruta2.toFile();

        if (!archivo2.exists()){
            Files.createFile(ruta2);
        }

        try (FileReader reader = new FileReader(archivo);
             FileWriter writer = new FileWriter(archivo2) ){

          int byteData;

          while ((byteData = reader.read()) != -1){


              try {
                  writer.append(Character.toUpperCase((char) byteData));

              } catch (IOException e) {
                  System.out.println("Error de escritura");
              }

          }
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }

    }
}
