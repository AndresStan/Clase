import java.util.Scanner;

public class ejercicio17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int total = 0;
        int mes = 1;
        int mesp = 0;

        boolean correcto2;

        int min = 0;
        int max = 0;

        for (int i = mes; i <= 12; i++){



                 correcto2 = false;

                 System.out.println("Para el mes " + i + " indica la facturación");




                      while (!correcto2) {
                             if (!sc.hasNextInt()) {
                                 System.out.println("Error, necesito un numero entero, porfavor indica un numero valido");
                                 sc.nextLine();
                             } else {
                                 mesp = sc.nextInt();
                                 sc.nextLine();

                                 if (mesp < 0) {

                                     System.out.println("Error, el numero tiene que ser mayor que 0");

                                 } else {
                                     correcto2 = true;
                                 }
                             }
                      }



                             if (i == 1) {
                                    max = mesp;
                                    min = mesp;
                             }
                             if (mesp > max) {
                                 max = mesp;
                             }

                             if (mesp < min) {
                                 min = mesp;
                             }

                             total = total + mesp;


        }

        System.out.println("El total anual es de " + total);
        System.out.println("La media es de: " + (total/12));
        System.out.println("El mayor valor mensual ha sido de: " + max);
        System.out.println("El menor valor mensual ha sido de: " + min);


    }
}
