import java.util.Scanner;

public class ejercicio14 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println(sumarCifras(num));

    }

    public static int sumarCifras(int numero) {

        if (numero == 0) {

            return 0;

        } else {
            return (numero % 10) + (sumarCifras(numero / 10));
        }




    }


}
