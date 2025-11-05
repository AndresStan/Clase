import java.util.*;


public class ej1 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Dime la altura que desee para el triangulo: ");

      while (!sc.hasNextInt()) {
          System.out.println("Indica algo valido");
          sc.nextLine();

      }


      int altura = sc.nextInt();
      sc.nextLine();

        while (altura < 0) {
            System.out.println("Porfavor, indica un caracter positivo");

            while (!sc.hasNextInt()) {
                System.out.println("Indica algo valido");
                sc.nextLine();

            }


            altura = sc.nextInt();
            sc.nextLine();
        }


      int i = 0;




      String asterisco = "*";

              for (int n = altura; n >=1; n--) {
                  i = n;
                while (i>=1) {
                    i = i - 1;
                    System.out.print(asterisco);
                }

                  System.out.println("");
              }


    }
}