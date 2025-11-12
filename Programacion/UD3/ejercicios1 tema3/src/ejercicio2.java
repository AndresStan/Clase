import java.lang.runtime.SwitchBootstraps;
import java.math.*;
import java.util.*;

public class ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un dia de la semana (1-7)");
        int dia = sc.nextInt();
        sc.nextLine();

        switch (dia) {
            case 5,7:
                System.out.println(" - ");
                break;
            case 1:
                System.out.println("Musica");
                break;
            case 2,4:
                System.out.println("Natación");
                break;
            case 3:
                System.out.println("Ingles");
                break;
            case 6:
                System.out.println("Deporte escolar");
                break;
            default:
                System.out.println("Valor erroneo");
        }



    }
}