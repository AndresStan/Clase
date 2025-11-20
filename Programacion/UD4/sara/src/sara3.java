import java.util.Scanner;

public class sara3 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double resultado = 0.0;
        System.out.println("(x•y) = (n•z)");
        System.out.println("Que quieres saber? (x/y/n/z)");

        int x = 0;
        int y = 0;
        int n = 0;
        int z =0;

        char letra = sc.next().charAt(0);

        if (letra == 'x') {
            System.out.println("Dime y");
            y = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime n");
            n = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime z");
            z = sc.nextInt();
            sc.nextLine();
            resultado = (double) (n * z) / y;

        }

        if (letra == 'y') {
            System.out.println("Dime x");
            x = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime n");
            n = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime z");
            z = sc.nextInt();
            sc.nextLine();
            resultado = (double) (n * z) / x;
        }

        if (letra == 'n') {
            System.out.println("Dime x");
            x = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime y");
            y = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime z");
            z = sc.nextInt();
            sc.nextLine();
            resultado = (double) (x * y) / z;
        }

        if (letra == 'z') {
            System.out.println("Dime x");
            x = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime y");
            y = sc.nextInt();
            sc.nextLine();

            System.out.println("Dime n");
            n = sc.nextInt();
            sc.nextLine();
            resultado = (double) (x * y) / n;
        }

        System.out.println("La respuesta es: " + resultado);
    }


}




