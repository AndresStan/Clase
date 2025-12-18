import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class escritura {
    static void main(String[] args) throws IOException {

        Path rutaTexto = Path.of("src\\media2\\texto.txt") ;
        File archivoTexto = rutaTexto.toFile();

        if (!archivoTexto.exists()){
            Files.createFile(rutaTexto);
        }



        // Para escribir  // true si queremos añadirlo al final y no
        // cargarnos lo que tenia el archivo

        try (FileOutputStream fos = new FileOutputStream(archivoTexto, true)){
            String anadimiento = " Añadido con fos ";

            fos.write(anadimiento.getBytes());

        }



        // Para leer y escribir a la vez  // true si queremos añadirlo al final y no
        // cargarnos lo que tenia el archivo

        try (RandomAccessFile raf = new RandomAccessFile(archivoTexto, "rw")) {
            // Escribir al final del archivo
            raf.seek(raf.length());

            raf.write("Añadido con randomAccess ".getBytes());


            // Me vuelvo a posicionar en el index 0 para leer
            raf.seek(0);

            String line;
            // Leer
            while ((line = raf.readLine()) != null) {
                System.out.println(line);
            }


        }
    }
}
