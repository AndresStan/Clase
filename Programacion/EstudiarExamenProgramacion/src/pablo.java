import java.util.ArrayList;
import java.util.Arrays;

public class pablo {
    static void main(String[] args) {


        String pascual = "Iker madura ya";
        char[] array = new char[6];

        pascual.getChars(5,11, array, 0 );

        System.out.println(Arrays.toString(array));
        String pascual2 = pascual.substring(12);
        System.out.println(pascual2);


        System.out.println(pascual.substring(0,4));

        System.out.println("-------------------------------------");

        System.out.println(pascual.lastIndexOf('a'));
        System.out.println(pascual.contains("adura"));

        String pollica = pascual.replace('a','z');
        System.out.println(pollica);
    }
}
