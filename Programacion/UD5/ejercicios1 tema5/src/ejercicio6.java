import javax.swing.text.ParagraphView;
import java.util.Random;


public class ejercicio6 {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[10];
        int positivos = 0;
        int negativos = 0;

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(21) -10;
            System.out.print(array[i] + " ");
            if (array[i] >= 0){
                positivos += 1;
            } else {
                negativos += 1;
            }
        }
        System.out.println(" ");
        System.out.println("Hay " + positivos + " numeros positivos");
        System.out.println("Hay " + negativos + " numeros negativos");



    }
}
