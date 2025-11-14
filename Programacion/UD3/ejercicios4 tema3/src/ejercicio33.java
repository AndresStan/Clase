import java.util.Scanner;

public class ejercicio33 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean terminado = false;
        int contador = 2;

        System.out.println("Dime un numero entero");
        int num = sc.nextInt();
        sc.nextLine();

       while (!terminado) {



           if (num % contador == 0) {

               System.out.print(num + "|" + contador);
               System.out.println(" ");
               num = num / contador;


           } else if (num == 1) {
               terminado = true;
               System.out.print(num);
           } else {
               contador = contador + 1;
           }

       }




    }
}
