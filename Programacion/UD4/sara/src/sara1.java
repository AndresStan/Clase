import java.util.Scanner;
import java.math.*;
public class sara1 {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero");
        int num = sc.nextInt();
        sc.nextLine();

        potencia(num);





    }


    static void potencia(int num){

        for (int i = 1; i <= 200; i++) {


            System.out.println(num + " elevado a la " + i + " = " + Math.pow(num, i));


        }


    }

}
