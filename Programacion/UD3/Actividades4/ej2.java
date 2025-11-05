import java.util.*;

public class ej2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Dime la altura de el rectangulo");

        while (!sc.hasNextInt()) {
            System.out.println("Indica algo valido");
            sc.nextLine();

        }


        int altura = sc.nextInt();
        sc.nextLine();

        while (altura < 0) {
            System.out.println("Porfavor indica un caracter positivo");

            while (!sc.hasNextInt()) {
                System.out.println("Indica algo valido");
                sc.nextLine();

            }

            altura = sc.nextInt();
            sc.nextLine();

        }

        System.out.println("Dime la anchura de el rectangulo");

        while (!sc.hasNextInt()) {
            System.out.println("Indica algo valido");
            sc.nextLine();

        }

        int anchura = sc.nextInt();
        sc.nextLine();

        while (anchura < 0) {
            System.out.println("Porfavor indica un caracter positivo");

            while (!sc.hasNextInt()) {
                System.out.println("Indica algo valido");
                sc.nextLine();

            }

            anchura = sc.nextInt();
            sc.nextLine();

        }




        for (int b = 0; b < altura; b++) {



                    for (int i = 1; i <= anchura; i++) {

                       if (b == 0 || b == altura-1) {
                           System.out.print("*");
                           if (i == anchura) {
                               System.out.println("");
                           }
                       } else {
                           if ( i == 1 || i == anchura) {
                               System.out.print("*");

                           } else {
                               System.out.print(" ");
                           }
                           if (i == anchura) {
                               System.out.println("");
                           }




                       }

                    }

        }


    }
}