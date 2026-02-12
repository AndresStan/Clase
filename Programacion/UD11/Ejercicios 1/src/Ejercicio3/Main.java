package Ejercicio3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> lista = new ArrayList<>();
        int numero;

        for (int i = 1; i <= 50; i++) {
        lista.add(random.nextInt(0,100));
        }

        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Porfavor indica un numero");
            numero = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ha habido un error");
            throw new RuntimeException(e);
        }

        long contador = lista.stream().filter(integer -> integer == numero).count();
        System.out.println("Hay " + contador + " en la lista");
    }
}
