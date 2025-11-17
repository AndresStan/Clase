import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un numero");
        int num = sc.nextInt();

        etm(num);

    }

    static void etm(int num) {

        for (int i = 1; i <= 10; i++){

            System.out.println(num + "*" + i + "=" + (num*i));


        }


    }
}
