package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();
        List<Integer> listaOrdenada = new ArrayList<>();

        try {
            for (int i = 1; i<=5;i++){
                System.out.println("Inserta el numero " + i);
                lista.add(sc.nextInt());
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la captura de numeros");
            throw new RuntimeException(e);

        }

        listaOrdenada = lista.stream().sorted().toList();

       if (lista.equals(listaOrdenada)){
           System.out.println("La lista esta ordenada correctamente de menor a mayor");
       } else {
           System.out.println("La lista no esta ordenada correctamente");
       }
    }
}
