import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero entero");
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime un numero entero");
        int num2 = sc.nextInt();
        sc.nextLine();


        System.out.println(menor(num1,num2) + " es menor");


    }

    static int menor(int num1,int num2) {
    int menor = 0;
        if (num1 < num2) {
            menor = num1;
        } else if (num2 < num1) {
            menor = num2;
        }
    return menor;
    }
}
