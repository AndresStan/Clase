import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println(factorial(num));


    }


    static int factorial(int num) {


        if (num == 1) {
            num = 1;

        } else {

            num = num * factorial(num-1);
        }
        return num;
    }
}
