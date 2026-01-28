import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Indica la ruta del fichero");

        // Path ruta = Path.of(sc.nextLine());

        Path ruta = Path.of("C:\\Users\\dam1\\Desktop\\Clase\\Programacion\\UD8\\EjerciciosOtraVezParaPracticar\\Ejercicios1\\media\\texto.txt");
        File archivo = ruta.toFile();

        Pattern patron = Pattern.compile("\\.[\\S]+");
        Matcher matcher = patron.matcher(ruta.toString());

        Pattern patron1 = Pattern.compile("^[A-Za-z0-9]+");
        Matcher matcher1 = patron1.matcher(ruta.getFileName().toString());




            System.out.println("Directorio raiz: " + ruta.getRoot());
            System.out.println("Directorio donde se encuentra el archivo: " + ruta.getParent());

            if (matcher1.find()){
                System.out.println("Nombre del archivo: " + matcher1.group());
            }

            if (matcher.find()){
                System.out.println("Extension del archivo: " + matcher.group());
            }

            if (archivo.exists()){
                System.out.println("El archivo existe");
            } else {
                System.out.println("El archivo no existe");
            }





    }
}
