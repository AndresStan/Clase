import java.util.Random;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {

                boolean esta = false;
                Scanner sc = new Scanner(System.in);
                Random random = new Random();
                int[] numerosAleatorios = new int[10];
                int num = 1;

                for (int i = 0; i < numerosAleatorios.length; i++) {
                    numerosAleatorios[i] = random.nextInt(100);
                }

                for (int i = 0; i < numerosAleatorios.length; i++) {
                    System.out.print(numerosAleatorios[i] + " ");
                }

                while (num >= 0){
                    esta = false;

                    System.out.println(" \n Introduce un numero entero");
                    num = sc.nextInt();
                    sc.nextLine();

                    for (int i =0; i < numerosAleatorios.length; i++){

                        if (num == numerosAleatorios[i]){
                            esta = true;
                        }

                    }

                    if (esta){
                        System.out.println("Está");
                    } else if (num < 0) {

                    } else {
                        System.out.println("No está");
                    }

                }


    }
}
