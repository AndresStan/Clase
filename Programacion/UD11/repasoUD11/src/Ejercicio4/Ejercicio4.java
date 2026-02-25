package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        String palabra = "";
        String buscar = "";
        String p = "";
        Scanner sc = new Scanner(System.in);
        List<String> lista = new ArrayList<>();

        try {
            while (!Objects.equals(palabra, "siguiente")) {

                System.out.println("Indica una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                sc.nextLine();

                if (!Objects.equals(palabra, "siguiente")) {
                    lista.add(palabra);
                }
            }
            System.out.println(lista.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            System.out.println("Indica la palabra a buscar ");
            buscar = sc.next();
            sc.nextLine();

            System.out.println("Indica la palabra que quieres poner ");
            p = sc.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


}

