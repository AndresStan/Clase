import java.util.Arrays;
import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {
        boolean ordenado = false;
        Scanner sc = new Scanner(System.in);
        int cantidad;


        System.out.println("Porfavor indica cuantos nombres va a introducir");
        cantidad = sc.nextInt();
        sc.nextLine();

        String[] array = new String[cantidad];

        for (int i = 0; i<array.length; i++){
            System.out.println("Porfavor indica el nombre " + (i+1));
            array[i] = sc.next();
            sc.nextLine();
        }
        Arrays.sort(array);
        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);

        }


    }
}
