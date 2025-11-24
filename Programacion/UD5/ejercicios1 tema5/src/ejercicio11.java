import java.util.Random;

public class ejercicio11 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();
        boolean serepite = false;

        for (int i = 0; i< array.length; i++){

           array[i] = random.nextInt(21) - 10;


        }

    while (serepite == false) {
        serepite = true;
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array.length; k++) {

                if (j != k) {
                    if (array[j] == array[k]) {

                        serepite = false;
                        array[k] = random.nextInt(21) - 10;


                    }


                }


            }
        }

    }

        for (int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");

        }

    }


}
