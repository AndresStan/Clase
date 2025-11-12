import java.util.Scanner;
public class ejercicio16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
                System.out.println("Dime cuantas pesetas tienes");
                if (sc.hasNextDouble()) {
                    double pesetas = sc.nextDouble();
                    sc.nextLine();
                    if (pesetas < 0) {
                        System.out.println("Error, el numero tiene que ser mayor que 0");
                    } else if (pesetas == 0) {
                        seguir = false;
                        System.out.println("Hasta luego!");
                    } else {

                            System.out.println(pesetas + " pesetas son " + String.format("%.2f", pesetas / 166.386) + " euros");

                    }

                } else {

                    System.out.println("Error, abortando");
                }
        }

    }
}
