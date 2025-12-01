import java.util.Random;

public class ejercicio12 {


    public static void main(String[] args) {

    }

    static int[] createRandom (int longitud, int min, int max){
        int[] array = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(max + 1 - min) + min ;
        }
        return array;
    }

    static void showArray (int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    static int find ( int[] array, int valor){
        int resultado = -1;
        boolean esta = false;
        for (int i = 0; i< array.length; i++){
            if (array[i] == valor){
                esta = true;
                resultado = i +1;
                break;
            }
        }
       return resultado;
    }

    static int findByIndex (int[] array, int valor, int index){
        int resultado = -1;
        boolean esta = false;
        for (int i = index-1; i< array.length; i++){
            if (array[i] == valor){
                esta = true;
                resultado = i +1;
                break;
            }
        }
        return resultado;
    }

    static int getMin(int[] array){
        int min = 0;
        for (int i = 0; i < array.length; i++){
            if (i == 0) {
                 min = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }

        }
        return min;
    }

    static int getMax(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i++){
            if (i == 0) {
                max = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }

        }
        return max;
    }

    static int getSum(int[] array){
        int suma = 0;
        for (int i = 0; i < array.length; i++){
            suma = suma + array[i];
        }
        return suma;
    }

    static double getAvg(int[] array){
        double suma = 0.0;
        for (int i = 0; i < array.length; i++){
            suma = suma + array[i];
        }
        return suma/ array.length;
    }

    static double[] getStats (int[] array){
        double[] Miarray = new double[4];

        Miarray[0] = getMin(array);
        Miarray[1] = getMax(array);
        Miarray[2] = getSum(array);
        Miarray[3] = getAvg(array);


        return Miarray;


    }
}