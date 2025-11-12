import java.math.*;
import java.util.*;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantas pesetas tienes");
        if (sc.hasNextDouble()) {
            double pesetas = sc.nextDouble();
            sc.nextLine();
            if (pesetas <=0 ) {
                System.out.println("Error, el numero tiene que ser mayor que 0");
            } else {
                System.out.println( pesetas + " pesetas son " + String.format("%.2f",pesetas/166.386) + " euros");
            }

        } else {

            System.out.println("Error, abortando");
        }
    }
}

