
import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");

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



        boolean sepuede = false;
        boolean haterminado = false;
        int i = 2;


        while (haterminado == false ) {

            System.out.print(numero + "|");
            i = 2;
            sepuede = false;

                    while (!sepuede) {

                                if (numero % i == 0) {
                                    System.out.print(i);
                                    System.out.println("");
                                    sepuede = true;
                                    numero = numero / i;
                                } else {
                                    i = i + 1;
                                }

                                if (i == numero) {
                                    haterminado = true;
                                    System.out.println(numero);
                                    System.out.println("1");
                                    sepuede = true;
                                }
                    }

        }





    }
}