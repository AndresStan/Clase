import java.util.Scanner;

public class ejercicio12 {
    static void main(String[] args) {

       fibonacci();

    }

    static void fibonacci(){
        int contador = 1;
        int numeroMaximo = 11;
        int num = 1;
        int anterior = 1;
        int anteriorAnterior = 0;


        System.out.print(anteriorAnterior + " ");
        System.out.print(anterior + " ");


        while (contador < numeroMaximo) {


            num = anterior + anteriorAnterior;
            System.out.print(num + " ");
            anteriorAnterior = anterior;
            anterior = num;
            contador++;
        }

    }
}
