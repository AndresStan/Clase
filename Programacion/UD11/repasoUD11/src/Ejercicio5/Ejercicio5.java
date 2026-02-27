package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> lista = new ArrayList<>();
        String buscar = "";

        String palabra = "";

        try {
            while (!Objects.equals(palabra, "siguiente")) {

                System.out.println("Indica una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                sc.nextLine();

                if (!Objects.equals(palabra, "siguiente")) {
                    lista.add(palabra);
                }
            }
            System.out.println(lista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            System.out.println("Indica la palabra a eliminar ");
            buscar = sc.next();
            sc.nextLine();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String finalBuscar = buscar;
        lista.remove(finalBuscar);
        System.out.println(lista);

    }
}
