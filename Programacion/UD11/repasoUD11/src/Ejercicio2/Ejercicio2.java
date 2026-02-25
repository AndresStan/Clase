package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i <= 2; i++){

            lista.add(random.nextInt(10));


        }

        for (int i = 0; i <= 2; i++){

            System.out.println(lista.get(i));

        }

    }
}
