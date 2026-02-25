package Ejercicio1;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ejercicio1 {
    public static void main(String[] args) {

        Path ruta = Path.of("src/Ejercicio1/DATA.csv");
        File archivo = ruta.toFile();
        boolean primeraLinea = true;
        List<Registro> tupla = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line = "";

            while ((line = reader.readLine()) != null){

                if (primeraLinea){
                    primeraLinea = false;
                } else {
                    String[] linea = line.split(",");
                    linea[9] = linea[9].replace(" ", "T");
                    tupla.add(new Registro(Integer.parseInt(linea[0]), linea[1], linea[2], Double.parseDouble(linea[3]),  Double.parseDouble(linea[4]), linea[5], linea[6], linea[7], linea[8],  LocalDateTime.parse(linea[9])));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //tupla.stream().filter(registro -> registro.getCountry().equalsIgnoreCase("FR")).forEach(System.out::println);

        //tupla.stream().filter(registro -> registro.getEmail().contains("@yahoo")).sorted(Comparator.comparing(Registro::getFirst_name)).forEach(System.out::println);

        //tupla.stream().filter(registro -> registro.getLast_login().isAfter(LocalDateTime.parse("2015-11-01T00:00:00")) && registro.getLast_login().isBefore(LocalDateTime.parse("2017-01-01T00:00:00"))).forEach(System.out::println);

        //tupla.stream().filter(registro -> registro.getFirst_name().startsWith("A")).sorted(Comparator.comparing(Registro::getLast_login).reversed()).map(registro -> registro.getFirst_name() + " " + registro.getLast_name()).forEach(System.out::println);

    }
}
