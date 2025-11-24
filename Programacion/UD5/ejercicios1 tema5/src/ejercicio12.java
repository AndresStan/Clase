import java.util.Random;

public class ejercicio12 {
    public static void main(String[] args) {
        createRandom(10,5,10);




    }

    static int[] createRandom (int longitud, int min, int max){

        int[] array = new int[longitud];
        Random random = new Random();

        for (int i = 0; i < array.length; i++){

            array[i] = random.nextInt(16) - 5;
            System.out.print(array[i] + " ");

        }


        return array;
    }
}
