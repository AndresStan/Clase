import java.util.Scanner;

public class ejercicio29 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean correcto1 = false;
        boolean correcto2 = false;
        int altura = 0;
        int anchura = 0;

        while (!correcto1) {

                    System.out.println("Dime la anchura de la forma");


                    if (!sc.hasNextInt()) {

                        System.out.println("Error, necesito un caracter valido");
                        sc.nextLine();
                        continue;

                    } else {

                        anchura = sc.nextInt();
                        sc.nextLine();

                        if (anchura < 0) {
                            System.out.println("Error, necesito un caracter positivo");
                            continue;
                        } else {

                            correcto1 = true;
                        }

                    }

        }

        while (!correcto2) {


                    System.out.println("Dime la altura de la forma");

                    if (!sc.hasNextInt()) {

                        System.out.println("Error, necesito un caracter valido");
                        sc.nextLine();
                        continue;

                    } else {

                        altura = sc.nextInt();
                        sc.nextLine();

                        if (altura < 0) {
                            System.out.println("Error, necesito un caracter positivo");
                            continue;

                        }



                        correcto2 = true;

                    }

        }



        for (int i = altura; i>0; i--){

            for (int j = anchura; j > 0; j --) {


                if (i == altura || i == 1 || j == anchura || j == 1 ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }

            System.out.println(" ");


        }



    }
}
