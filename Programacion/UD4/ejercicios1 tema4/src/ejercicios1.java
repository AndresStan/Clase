import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ejercicios1 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero real negativo");
        double num = sc.nextDouble();
        sc.nextLine();

        System.out.println((int) signo(num));

    }

    static double signo(double num) {

        if (num < 0 ) {

            num = -1;


        }

        if (num == 0 ) {

            num = 0;

        }

        if (num > 0 ) {

            num = 1;

        }


        return num;


    }


}
