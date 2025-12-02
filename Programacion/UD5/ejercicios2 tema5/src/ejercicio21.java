import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ejercicio21 {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int contador = 0;
        String frase = sc.nextLine();
        ArrayList<Integer> posiciones = new ArrayList<>();

        for (int i = 0; i < frase.length(); i++) {
            if (frase.toLowerCase().charAt(i) == 'á' || frase.toLowerCase().charAt(i) == 'a'){
                contador++;
                posiciones.add(i);
            }
        }

        System.out.println("En la frase hay " + contador + " ases en las posicinoes: " + posiciones);

    }

}
