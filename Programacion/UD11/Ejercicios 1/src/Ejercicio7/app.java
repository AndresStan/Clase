package Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class app {
    public static void main(String[] args) {

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        String palabra = "";

        try (Scanner sc = new Scanner(System.in)){
            while (!Objects.equals(palabra, "siguiente")) {
                System.out.println("Indica una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                if (!Objects.equals(palabra, "siguiente")){
                    lista1.add(palabra);
                }
            }

            System.out.println("Segunda lista de palabras:");
            palabra = "";
            sc.nextLine();
            while (!Objects.equals(palabra, "siguiente")) {
                System.out.println("Indica una palabra o 'siguiente' para continuar");
                palabra = sc.next();
                if (!Objects.equals(palabra, "siguiente")){
                    lista2.add(palabra);
                }
            }

            //- Lista de palabras que aparecen en las dos listas.
            // List<String> EJ1Lista = lista1.stream().filter(lista2::contains).distinct().toList();
            // System.out.println(EJ1Lista);


            //- Lista de palabras que aparecen en la primera lista, pero no en la segunda.
            // List<String> EJ2Lista = lista1.stream().filter(string -> !lista2.contains(string)).distinct().toList();
            // System.out.println(EJ2Lista);


            //- Lista de palabras que aparecen en la segunda lista, pero no en la primera.
            // List<String> EJ3Lista = lista2.stream().filter(string -> !lista1.contains(string)).distinct().toList();
            // System.out.println(EJ3Lista);


            //- Lista de palabras que aparecen en alguna de las dos listas.
            List<String> EJ4Lista = new ArrayList<>(lista1);
            EJ4Lista.addAll(lista2);
            EJ4Lista = EJ4Lista.stream().distinct().toList();
            System.out.println(EJ4Lista);






        } catch (Exception e){
            System.out.println("Ha habido un error en la escritura de palabras");
            System.out.println(e.getMessage());

        }




    }
}
