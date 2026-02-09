package Ejercicio1;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {

        Path ruta = Path.of("src/Ejercicio1/DATA.csv");
        File archivo = ruta.toFile();
        List<Registro> tupla = new ArrayList<>();
        Boolean primeraLinea = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
             while ((line = reader.readLine()) != null){
                 if (primeraLinea){
                     primeraLinea = false;
                 } else {
                     String[] array = line.split(",");
                     array[9] = array[9].replace(" ", "T");
                     tupla.add(new Registro(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]), Double.parseDouble(array[4]), array[5], array[6], array[7], array[8], LocalDateTime.parse(array[9])));
                 }
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Los registros del pais Francia (FR)
        // tupla.stream().filter(registro -> registro.getPais().equalsIgnoreCase("FR")).forEach(System.out::println);

        // Los registros de email "yahoo" ordenados por nombre
        // tupla.stream().filter(registro -> registro.getCorreo().contains("@yahoo")).sorted(Comparator.comparing(Registro::getPrimerNombre)).forEach(System.out::println);


        // Los registros con el último login entre noviembre de 2015 y enero de 2017
        // ambos incluidos ordenados por fecha de manera descendente.
        tupla.stream().filter(registro -> registro.getUltimoLogin().isAfter(LocalDateTime.of(2015, 11, 1, 0, 0)) && registro.getUltimoLogin().isBefore(LocalDateTime.of(2017, 1, 1, 0, 0))).sorted(Comparator.comparing(Registro::getUltimoLogin).reversed()).forEach(System.out::println);

    }
}
