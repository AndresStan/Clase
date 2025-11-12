import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int contador = 0;

        System.out.println("Dime un numero entero");
        if (!sc.hasNextInt()) {

            System.out.println("Error, necesito un numero entero");
            return ;

        }
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime otro numero enero mayor que 0");
        if (!sc.hasNextInt()) {

            System.out.println("Error, necesito un numero entero");
            return ;

        }
        int num2 = sc.nextInt();
        sc.nextLine();

        if (num2 == 0) {
            System.out.println("Error, tiene que ser un numero mayor que 0");
            return;
        }

        for (int i = num1; i >= num2; i= i-num2){
            contador = contador + 1;



        }
        System.out.println(contador);
    }
}
