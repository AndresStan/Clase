import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio1 {
    public static void main(String[] args) {

        Path ruta = Paths.get("C:\\Users\\dam1\\Desktop\\unnamed.png");
        File file = new File(ruta.toString());

        System.out.println(ruta.getRoot());

        System.out.println(ruta.getParent().toString().substring(ruta.getParent().toString().lastIndexOf("\\" ) +1));
        System.out.println(ruta.getFileName().toString().substring(0, ruta.getFileName().toString().indexOf(".")));
        System.out.println(ruta.getFileName().toString().substring(ruta.getFileName().toString().lastIndexOf(".")));
        System.out.println("El fichero existe?: " + file.exists());

    }
}