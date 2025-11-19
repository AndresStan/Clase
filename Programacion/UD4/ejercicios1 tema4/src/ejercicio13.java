import java.util.Scanner;

public class ejercicio13 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime hasta que numero de fibonacci desea saber");
        int num = sc.nextInt();
        sc.nextLine();

        fibonacci(num);

    }
    static void fibonacci(int numeroMaximo){

        int num = 0;
        int anterior = 1;
        int anteriorAnterior = 0;
        int contador = 2;
        System.out.print(anteriorAnterior + " ");
        System.out.print(anterior + " ");
        while (contador < numeroMaximo) {

            num = anterior + anteriorAnterior;
            System.out.print(num + " ");
            anteriorAnterior = anterior;
            anterior = num;

            contador++;
        }
    }
}
