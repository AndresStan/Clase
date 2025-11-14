import java.util.Scanner;

public class ejercicio32 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Porfavor, indica un numero entero");
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i < num; i++) {



                if (num % i == 0) {
                    System.out.print(i + ", ");
                }

        }



    }





}
