import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ejercicio2 {
    public static void main(String[] args) {

        Path ruta = Paths.get("C:\\Users\\dam1\\Desktop");
        File ruta2 = new File(ruta.toString());

        System.out.println(ruta.getParent());

        if (ruta2.exists()){
            System.out.println("Existe");

            if (ruta.getFileName().toString().contains(".")){
                System.out.println("Se trata de un archivo");
            } else {
                System.out.println("Se trata de un directorio");
                for (File e : ruta2.listFiles()){
                    System.out.println(e);
                }
            }

        } else {
            System.out.println("No existe");
        }




    }
}
