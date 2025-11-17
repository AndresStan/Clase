import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime otro numero entero distinto");
        int num2 = sc.nextInt();
        sc.nextLine();

        System.out.println(entero(num1,num2) + " es mayor");

        System.out.println("Ahora dime un numero real");
        double num1d = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ahora dime otro numero real distinto");
        double num2d = sc.nextDouble();
        sc.nextLine();

        System.out.println(doble(num1d,num2d) + " es mayor");


    }

    static int entero(int num1, int num2){

        int resultado = 0;
        if (num1 > num2) {
           resultado = num1;

        }
        if (num2 > num1) {
            resultado = num2;



        }
        return resultado;


    }

    static double doble(double num1, double num2) {
        double resultado = 0.0;

        if (num1 > num2){

            resultado = num1;
        }

        if (num2 > num1) {

            resultado = num2;
        }

        return resultado;


    }
}
