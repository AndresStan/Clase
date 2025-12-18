import java.io.*;
import java.nio.file.Path;

public class lectura {
    static void main(String[] args) {

        Path rutaBinario = Path.of("src\\media\\binario.png");
        File archivoBinario = rutaBinario.toFile();

        Path rutaTexto = Path.of("src\\media\\texto.txt");
        File archivoTexto = rutaTexto.toFile();

        System.out.println("---------Prueba para leer imagen--------------------- ");

        // Prueba para leer imagen (bytes)
        try (FileInputStream fis = new FileInputStream(archivoBinario)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print( byteData);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------Prueba para leer texto----------------------- ");
        // Prueba para leer texto (chars)
        try (FileReader reader = new FileReader(archivoTexto)) {

            int byteData;

            while ((byteData = reader.read()) != -1){

                System.out.print( (char) byteData);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" ");
        System.out.println(" ");
        // Prueba para leer texto bufferizado
        System.out.println("-------Prueba para leer texto bufferizado----------------------- ");

        try (BufferedReader breader = new BufferedReader(new FileReader(archivoTexto))){

            String linea;

            while ((linea = breader.readLine()) != null){
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}