import java.util.Scanner;

public class ejercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resultado = 0;

        System.out.println("Dime un numero entero");
        if (!sc.hasNextInt()){
            System.out.println("Error, necesito un numero entero");
            return;
        }
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime otro numero entero");
        if (!sc.hasNextInt()){
            System.out.println("Error, necesito un numero entero");
            return;
        }
        int num2 = sc.nextInt();
        sc.nextLine();

        for (int i = num2; i > 0; i--) {

            resultado = resultado + num1;

        }
        System.out.println(resultado);

    }
}

