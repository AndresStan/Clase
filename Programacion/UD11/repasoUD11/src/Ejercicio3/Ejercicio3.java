package Ejercicio3;

import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<Integer> mapa = new ArrayList<>();

        for (int i = 0; i < 50; i++){
           mapa.add(random.nextInt(100));
        }

        for (int i = 0; i < 50; i++){
            System.out.println(mapa.get(i));
        }

        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("Hay " + mapa.stream().filter(integer -> integer.equals(num)).count());


    }
}
