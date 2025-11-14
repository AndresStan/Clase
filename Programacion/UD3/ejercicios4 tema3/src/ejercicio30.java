import java.util.Scanner;

public class ejercicio30 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int altura = 0;
        boolean correcto = false;


        while (!correcto) {

            System.out.println("Dime la altura que desea para el triangulo creciente");

            if (!sc.hasNextInt()) {

                System.out.println("Error, necesito un valor numerico");
                sc.nextLine();

            } else if (sc.hasNextInt()) {

                altura = sc.nextInt();
                sc.nextLine();

                if (altura < 0) {
                    System.out.println("Error, necesito un valor numerico positivo");
                } else {
                    correcto = true;



                }

            }

        }



        for (int i = 0; i < altura; i++ ) {
            for (int j = i+1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println("");


        }





    }
}
