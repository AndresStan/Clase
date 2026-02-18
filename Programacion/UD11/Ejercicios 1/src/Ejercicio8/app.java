package Ejercicio8;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class app {
    public static void main(String[] args) {

       String frase = "";
       TreeMap<Character, Long> contadorLetras = new TreeMap<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduzca una frase");
            frase = sc.nextLine().replaceAll(" ", "");

            for (Character c : frase.toCharArray()){
                contadorLetras.put(c, contadorLetras.containsKey(c) ? contadorLetras.get(c) +1 : 1);
            }

            


        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(contadorLetras);



    }
}
