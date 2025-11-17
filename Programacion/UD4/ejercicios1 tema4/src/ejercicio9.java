import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");
        int num = sc.nextInt();
        sc.nextLine();

        cuentaAtras(num);

    }

    static void cuentaAtras(int num){

        if (num == 1) {
            System.out.println(1);
        } else {
            System.out.println(num);
            cuentaAtras(num-1);

        }


    }
}
