import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int contador = 1;

        System.out.println("Dime un numero entero positivo");
        if (!sc.hasNextInt()) {
            System.out.println("Error necesto un numero entero");
            return;
        }
        int num = sc.nextInt();
        sc.nextLine();
        if (num <= 0) {
            System.out.println("Error, necesito un numero entero positivo");
            return;
        }

        for (int i = num; i >= 10; i = i /10 ) {

            contador = contador + 1;
        }
        System.out.println("El numero tiene " + contador + " cifras");

    }
}
