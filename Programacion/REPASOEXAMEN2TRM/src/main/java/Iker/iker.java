package Iker;

import java.util.*;

public class iker {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase");
        String frase = sc.nextLine();
        frase = frase.replaceAll(" ", "");
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (Character c : frase.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        System.out.println(map.entrySet());


        List<Map.Entry<Character, Integer>> lista = new ArrayList<>(map.entrySet());

        System.out.println(lista);

    }


}
