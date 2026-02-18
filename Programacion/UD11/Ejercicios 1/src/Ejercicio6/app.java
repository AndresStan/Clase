package Ejercicio6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            lista.add(random.nextInt(0,100));
        }

        System.out.println("Lista sin el cambio");
        System.out.println(lista);

        System.out.println("Lista con el cambio");
        List<Integer> nLista = lista.stream().distinct().toList();
        System.out.println(nLista);

    }
}
