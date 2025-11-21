import java.util.Random;

public class ejercicio8 {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        for (int i = 0; i < array1.length; i++) {

            array1[i] = random.nextInt(21) - 10;
            System.out.print(array1[i] + " ");

        }
        System.out.println(" ");

        for (int i = 0; i < array1.length; i++) {

            array2[i] = random.nextInt(21) - 10;
            System.out.print(array2[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < array1.length; i++) {

            array3[i] = array1[i] + array2[i];
            System.out.print(array3[i] + " ");
        }

    }
}
