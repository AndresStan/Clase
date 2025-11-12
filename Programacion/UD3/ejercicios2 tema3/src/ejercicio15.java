import java.util.Scanner;

public class ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        int resultado = 1;
        if (!sc.hasNextInt()) {
            System.out.println("Error, necesito un numero entero");
            return;
        }
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = num; i > 0; i-- ) {

            resultado = resultado * i;
        }

        System.out.println(resultado);
    }
}
