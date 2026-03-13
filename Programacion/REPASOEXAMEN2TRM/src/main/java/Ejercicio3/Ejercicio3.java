package Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        String palabra = "";

        /*
        try {
            System.out.println("Primera lista");
            while (!palabra.equals("siguiente")){
                System.out.println("Introduce una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                if (!palabra.equals("siguiente")){
                    lista1.add(palabra);
                }
                sc.nextLine();
            }

            System.out.println(lista1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        palabra = "";


        try {
            System.out.println("Segunda lista");
            while (!palabra.equals("siguiente")){
                System.out.println("Introduce una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                if (!palabra.equals("siguiente")){
                    lista2.add(palabra);
                }
                sc.nextLine();
            }

            System.out.println(lista2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */


        lista1 = new ArrayList<>(Arrays.asList("Ann", "Carol", "Mary", "Joe",
                "John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George",
                "Ann", "Johnny", "Charlie", "Hillary"));

        lista2 = new ArrayList<>(Arrays.asList("Ann", "Martha", "Noel",
                "Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred",
                "Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler"));


        List<String> finalLista2 = lista2;
        List<String> finalLista1 = lista1;
        // lista1.stream().filter(finalLista::contains).distinct().forEach(System.out::println);

        // lista1.stream().filter(s -> !finalLista.contains(s)).forEach(System.out::println);

        // lista2.stream().filter(s -> !finalLista1.contains(s)).distinct().forEach(System.out::println);

        lista1.addAll(lista2); lista1.stream().distinct().forEach(System.out::println);

    }


}
