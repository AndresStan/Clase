import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ejercicio2 {
    public static void main(String[] args) throws FileNotFoundException {

        Path ruta = Path.of("C:\\Users\\dam1\\desktop\\Clase\\Programacion\\UD8\\EjerciciosOtraVezParaPracticar\\Ejercicios1\\media2\\fichero.txt");
        File archivo = ruta.toFile();

        System.out.println("Subcarpeta: " + ruta.getParent());
        if (archivo.exists()) {
            System.out.println("La ruta existe");
            if (archivo.isDirectory()){
                System.out.println("Es un directorio");
                System.out.println(Arrays.toString(archivo.list()));
            } else if (archivo.isFile()) {
                System.out.println("Es un fichero");
                System.out.println("CONTENIDO: --------");
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

                    String linea;

                    while ((linea = reader.readLine()) != null){
                        System.out.println(linea);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                System.out.println("El archivo no es un directorio ni un fichero");
            }
        }



    }
}
