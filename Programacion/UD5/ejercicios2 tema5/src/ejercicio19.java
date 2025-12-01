import java.util.Scanner;

public class ejercicio19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int suma = 0;
        String numeros;

        System.out.println("Indica varios numeros separados por una coma");
        numeros = sc.next();

        String[] words = numeros.split(",");


        for (String word : words) {

            suma = suma + Integer.valueOf(word);
        }
        System.out.println(suma );
    }
}
