import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la altura del triangulo");

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

        String asterisco = "*";
        int contador = 0;

        for (int i = 1; i <= altura; i++ ) {
            contador = i;
            while (contador != 0) {
                System.out.print(asterisco);
                contador = contador - 1;
            }
            System.out.println(" ");


        }




    }
}