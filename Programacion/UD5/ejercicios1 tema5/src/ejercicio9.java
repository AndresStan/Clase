import java.util.Random;

public class ejercicio9 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();


        for (int i = 0; i < array.length; i++){

            array[i] = random.nextInt(21) -10;
            System.out.print(array[i] + " ");


        }

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if (i != j) {

                    if (array[i] == array[j] ){
                        System.out.println("El " + array[i] + " se repite");

                    }

                }
            }

        }


    }
}
