import java.util.Scanner;

public class ejercicio24 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica una palabra");
        String frase = sc.next();

        StringBuilder fraseInvertida = new StringBuilder(frase);
        fraseInvertida.reverse();


        if (limpia(fraseInvertida.toString()).equals(limpia(frase))) {
            System.out.println("Es palindromo");
        }

    }

    static String limpia(String t) {
        return t.toLowerCase()
                .replace("á","a")
                .replace("é","e")
                .replace("í","i")
                .replace("ó","o")
                .replace("ú","u")
                .replace("ü","u");
    }

}
