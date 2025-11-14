import java.util.Scanner;

public class ejercicio28 {
    static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        boolean correcto = false;


        while (!correcto) {

                            System.out.println("Dime la altura que desea para el triangulo decreciente");

                            if (!sc.hasNextInt()) {

                                System.out.println("Error, necesito un valor numerico");
                                sc.nextLine();

                            } else if (sc.hasNextInt()) {

                                int altura = sc.nextInt();
                                sc.nextLine();

                                if (altura < 0) {
                                    System.out.println("Error, necesito un valor numerico positivo");
                                } else {
                                    correcto = true;
                                    for (int i = altura; i > 0; i--) {

                                        for (int j = i; j > 0; j--) {
                                            System.out.print("*");

                                        }
                                        System.out.println(" ");
                                    }


                                }

                            }

        }
    }
}
