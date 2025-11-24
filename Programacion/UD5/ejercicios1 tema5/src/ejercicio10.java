import java.util.Random;

public class ejercicio10 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();
        boolean serepite = false;

        for (int i = 0; i<array.length; i++){

            array[i] = random.nextInt(21) -10 ;
            System.out.print(array[i] + " ");

        }
        System.out.println(" ");

        for (int j = 0; j < array.length; j++){
            serepite = false;
            for (int k = 0; k<array.length; k++){

                if (j != k) {
                    if (array[j] == array[k]){
                     serepite = true;



                    }
                }
            }

            if (!serepite) {
                System.out.print(array[j] + " ");
            }
        }


    }
}
