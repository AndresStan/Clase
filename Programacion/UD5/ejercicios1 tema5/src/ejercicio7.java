import javax.security.auth.Refreshable;
import java.util.Random;


public class ejercicio7 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + " ");
            if (array[i] < 0) {
                array[i] = -array[i];
            }

        }

        System.out.println(" ");

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

        }

    }
}
