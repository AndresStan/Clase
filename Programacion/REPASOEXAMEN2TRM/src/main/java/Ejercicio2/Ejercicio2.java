package Ejercicio2;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {

    static void main(String[] args) {

        Path ruta = Path.of("src/main/java/Ejercicio2/texto.txt");
        File archivo = ruta.toFile();
        Pattern regex = Pattern.compile("\\b[\\w]+\\b");
        HashMap<Character,Integer> map = new HashMap<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            String line;

            while ((line = reader.readLine()) != null){

                Matcher matcher = regex.matcher(line);
                while (matcher.find()){

                 map.put(matcher.group().toLowerCase().charAt(0), map.getOrDefault(matcher.group().toLowerCase().charAt(0), 0) +1);


                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(map.entrySet());
        }


        List<Map.Entry<Character, Integer>> lista = new ArrayList<>(map.entrySet());

        lista = lista.stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).toList().reversed();

        LinkedHashMap<Character, Integer> mapaOrdenado = new LinkedHashMap<>();

        for (Map.Entry<Character, Integer> mp : lista){
            mapaOrdenado.put(mp.getKey(), mp.getValue());
        }

        mapaOrdenado.entrySet().stream().limit(3).forEach(System.out::println);




    }
}
