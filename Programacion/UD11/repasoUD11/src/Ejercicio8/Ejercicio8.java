package Ejercicio8;

import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TreeMap;

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeMap<Character, Long> lista = new TreeMap<>();

        try{
            System.out.println("Introduce una frase");
            String frase = sc.nextLine();
            char[] frasePorCaracteres = frase.toCharArray();
            for (char c : frasePorCaracteres){
                if (c != ' '){
                    lista.put(c, lista.containsKey(c) ? lista.get(c) +1 : 1);
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(lista);




    }
}
