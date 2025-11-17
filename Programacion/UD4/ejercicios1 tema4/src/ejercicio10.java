import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println(factorial(num));


    }

    static int factorial(int num){
    int resultado = 1;
        for (int i = num; i > 0; i--){
            resultado = resultado * i;

        }

        return resultado;
    }
}
