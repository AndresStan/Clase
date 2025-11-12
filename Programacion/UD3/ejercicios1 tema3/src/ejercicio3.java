import java.util.*;
import java.math.*;


public class ejercicio3 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una tecla");
        char tecla = sc.next().charAt(0);
        if (tecla >= 48 && tecla <= 57) {
            System.out.println("Es un digito");
        } else if ((tecla >= 65 && tecla <= 122)) {
            System.out.println("Es una letra");
        } else {
            System.out.println("Es otro caracter");
        }

    }
}
