package Ejercicio3;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio3 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String frase;
        boolean hayRepetido = false;

        HashMap<Character, Long> lista = new HashMap<Character, Long>();


        try {
            System.out.println("Introduce una frase");
            frase = sc.nextLine();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la captura de la frase");
            throw new RuntimeException(e);
        }

        char[] frasePorCaracteres = frase.toCharArray();
        for (char c : frasePorCaracteres){
            if (c != ' '){

                if (lista.containsKey(c) && !hayRepetido){
                    hayRepetido = true;
                    System.out.println("El primer caracter repetido es: " + c);
                }
                lista.put(c, lista.containsKey(c) ? lista.get(c) +1 : 1);

            }
        }

        if (!hayRepetido){
            System.out.println("No hay ningun caracter repetido en la frase");
        }

    }



}
