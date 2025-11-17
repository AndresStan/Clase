import java.sql.Savepoint;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la nota que has sacado");
        int nota = sc.nextInt();
        sc.nextLine();

        funcion(nota);


    }

    static void funcion(int nota){
        switch (nota) {

            case 1,2,3,4:
                System.out.println("Suspenso");
                break;

            case 5,6:
                System.out.println("Suficiente");
                break;

            case 7,8:
                System.out.println("Notable");
                break;

            case 9,10:
                System.out.println("SobreSaliente");
                break;

            default:
                System.out.println("Nota incorrecta");
                break;

        }

    }
}
