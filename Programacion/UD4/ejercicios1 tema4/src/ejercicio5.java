import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime una letra");
        char letra = sc.next().charAt(0);
        sc.nextLine();

        System.out.println("Dime la anchura que deseas");
        int anchura = sc.nextInt();
        sc.nextLine();

        triangulo(letra,anchura);




    }

    static void triangulo(char letra, int anchura ) {

        for (int i = anchura; i >0; i--) {

            for (int j = i; j > 0; j--) {
                System.out.print(letra);

            }

            System.out.println(" ");
        }


    }
}
