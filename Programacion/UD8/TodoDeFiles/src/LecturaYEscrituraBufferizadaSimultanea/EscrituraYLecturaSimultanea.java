package LecturaYEscrituraBufferizadaSimultanea;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class EscrituraYLecturaSimultanea {

    public static void main(String[] args){


        String texto = "Voy a añadir este texto y luego leerlo entero";
        Path ruta = Path.of("media/EscrituraYLecturaSimultanea.txt");
        File archivo = ruta.toFile();

        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {

            raf.seek(raf.length());
           raf.write(texto.getBytes());
            raf.write("\n".getBytes());

           String line;
           while ((line = raf.readLine()) != null){
               System.out.println(line);
           }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
