
import java.util.Scanner;
import java.math.*;

public class ej5 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");
        boolean esprimo = true;
        while (!sc.hasNextInt()) {
            System.out.println("Indica algo valido");
            sc.nextLine();

        }


        int numero = sc.nextInt();
        sc.nextLine();

        while (numero < 0) {
            System.out.println("Porfavor indica un caracter positivo");

            while (!sc.hasNextInt()) {
                System.out.println("Indica algo valido");
                sc.nextLine();

            }

            numero = sc.nextInt();
            sc.nextLine();

        }


        for ( int i = 2; i < numero; i++) {

            if ( numero % i == 0) {
                esprimo = false;
                System.out.print(i + " ");

            }



        }

        if (esprimo) {
            System.out.println("El numero indicado es primo, por lo que no tiene divisores");
        }

    }
}