import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero real");
        double numero = sc.nextDouble();
        sc.nextLine();
        System.out.println(signo(numero));

    }

    static int signo(Double num) {
        int resultado = 0;
        if (num > 0) {
            resultado = 1;
        } else if (num == 0) {
            resultado = 0;
        } else if (num < 0) {
            resultado = -1;
        }


        return resultado;
    }

}
