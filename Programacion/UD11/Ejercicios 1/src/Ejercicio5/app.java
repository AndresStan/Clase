package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        String palabra = " ";
        String palabraBuscar = " ";
        String nuevaPalabra = " ";
        Scanner sc = new Scanner(System.in);

        try {

            while (!palabra.equalsIgnoreCase("siguiente")) {
                System.out.println("Introduce una palabra o 'siguiente' para terminar");
                palabra = sc.next();
                if (!palabra.equalsIgnoreCase("siguiente")){
                    lista.add(palabra);
                }
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error en la captura de palabras");
            throw new RuntimeException(e);
        }

        sc.nextLine();

        try {
            System.out.println("Introduce una palabra a eliminar");
            palabraBuscar = sc.next();


        } catch (Exception e) {
            System.out.println("Ha habido un error en la captura de palabras");
            throw new RuntimeException(e);
        }


        if (lista.contains(palabraBuscar)){

            System.out.println("Palabra [" + palabraBuscar  + "] encontrada, eliminando...");
            lista.remove(palabraBuscar);

        }


        System.out.println("Lista final:");
        System.out.println(lista.toString());



    }
}
