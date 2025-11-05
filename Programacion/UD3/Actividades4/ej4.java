import java.util.*;
import java.math.*;

public class ej4 {
    public static void main(String[] args) {

        int contador = 0;
        int max = 0;
        int min = 0;

            do {
                Double salida = Math.random()*100;
                int num = (int) Math.round(salida);
                System.out.println(num);

                if (contador == 0) {
                    max = num;
                    min = num;

                }

                if (num < min) {
                    min = num;
                }

                if (num > max) {
                    max = num;
                }
                contador = contador + 1;

            } while (contador < 10);


            System.out.println("El mayor es " + max );
            System.out.println("El menor es " + min );


    }
}