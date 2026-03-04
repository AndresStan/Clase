package Ejercicio4;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4 {
    public static void main(String[] args) {

        Path ruta = Path.of("src/main/java/Ejercicio4/MetadatainDBMS.txt");
        File archivo = ruta.toFile();

        HashMap<String, Integer> lista = new HashMap<>();
        Pattern patron = Pattern.compile("[\\w'’]+");




        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

            String line;
            int num = 1;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = patron.matcher(line);
                while (matcher.find()) {

                    lista.put(matcher.group().toLowerCase(), lista.containsKey(matcher.group().toLowerCase()) ? lista.get(matcher.group().toLowerCase()) + 1 : 1);


                }

            }
            List<Map.Entry<String, Integer>>  listaNueva = new ArrayList<>(lista.entrySet());
            listaNueva.sort((a, b) -> b.getValue() - a.getValue());

            // Mostrar las tres palabras más frecuentes
            System.out.println("Las tres palabras más frecuentes son:");
            for (int i = 0; i < 3 && i < listaNueva.size(); i++) {
                System.out.println(listaNueva.get(i).getKey() + ": " + listaNueva.get(i).getValue());
            }



        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en tiempo de ejecución");
            throw new RuntimeException(e);
        }






    }



}
