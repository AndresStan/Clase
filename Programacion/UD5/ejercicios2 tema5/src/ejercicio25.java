import java.util.Scanner;

public class ejercicio25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica una palabra:");
        String frase = sc.next();

        // Limpiamos la palabra
        String fraseLimpia = limpia(frase);

        // Comprobamos con recursión
        if (esPalindromo(fraseLimpia)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
    }

    // Función recursiva para comprobar palíndromo
    static boolean esPalindromo(String t) {
        // Caso base: si la longitud es 0 o 1, es palíndromo
        if (t.length() <= 1) {
            return true;
        }

        // Comparamos primer y último carácter
        if (t.charAt(0) != t.charAt(t.length() - 1)) {
            return false;
        }

        // Llamada recursiva con la subcadena interna
        return esPalindromo(t.substring(1, t.length() - 1));
    }

    // Función para limpiar acentos y normalizar
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
