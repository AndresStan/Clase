package Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        String palabra = "";

        try {
            System.out.println("PRIMERA LISTA");

            while (!Objects.equals(palabra, "siguiente")){
                System.out.println("Introduce una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                sc.nextLine();
                if (!Objects.equals(palabra, "siguiente")){
                    lista1.add(palabra);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            System.out.println(lista1);
        }

        palabra = "";

        try {
            System.out.println("SEGUNDA LISTA");

            while (!Objects.equals(palabra, "siguiente")){
                System.out.println("Introduce una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                sc.nextLine();
                if (!Objects.equals(palabra, "siguiente")){
                    lista2.add(palabra);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            System.out.println(lista2);
        }

        //• Lista de palabras que aparecen en las dos listas.
        // lista1.stream().filter(lista2::contains).forEach(System.out::println);

        //• Lista de palabras que aparecen en la primera lista, pero no en la segunda.
        // lista1.stream().filter(s -> !lista2.contains(s)).forEach(System.out::println);

        //• Lista de palabras que aparecen en la segunda lista, pero no en la primera.
        //lista2.stream().filter(s -> !lista1.contains(s)).distinct().forEach(System.out::println);

        //• Lista de palabras que aparecen en alguna de las dos listas.
        //List<String> listaEJ4 = lista1;
        //listaEJ4.addAll(lista2);
        //listaEJ4.stream().distinct().forEach(System.out::println);

    }
}
