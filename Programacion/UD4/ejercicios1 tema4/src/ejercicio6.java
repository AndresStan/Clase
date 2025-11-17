import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero");
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime otro numero");
        int num2 = sc.nextInt();
        sc.nextLine();

        System.out.println(funcion(num1,num2));


    }


    static double funcion(double num1, double num2){
        return (num1 + num2) / 2;
    }
}
