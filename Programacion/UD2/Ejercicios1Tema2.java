import java.util.*;
import java.lang.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dia15 {
    public static void main(String[] args) {

        Scanner nigga = new Scanner(System.in);


        //Ejercicio 6

        System.out.print("Dame el primer numero");
        int p1 = nigga.nextInt();
        System.out.print("Dame el segundo numero");
        int p2 = nigga.nextInt();


        if (p1 == p2){
            System.out.println("Error, tienen que ser numeros diferentes");
        } else {

            if (p1 > p2) {

                System.out.println(p1 + " Es mayor que " + p2);
                if (p1 % p2 == 0) {
                    System.out.println(p1 + " Es multiplo de " + p2);
                } else {
                    System.out.println(p1 + " No es multiplo de " + p2);
                }
            }

            if (p2 > p1) {

                System.out.println(p2 + " Es mayor que " + p1);

                if (p2 % p1 == 0) {
                    System.out.println(p2 + " Es multiplo de " + p1);
                } else {
                    System.out.println(p2 + " No es multiplo de " + p1);
                }
            }
        }









        //Ejercicio 5 A

        double qwee = Math.random()*100;
        int qweee = (int)qwee;

        System.out.println(qweee);


        //Ejercicio 5 B


        System.out.print("Dame un numero positivo ");
        int port = nigga.nextInt();

        double qweer = Math.random()*port;
        int qweeet = (int)qweer;

        System.out.println(qweeet);

        //Ejercicio 5 C

        System.out.println("Dame un numero inicial");
        int nummin = nigga.nextInt();

        System.out.println("Dame un numero Final");
        int nummaxx = nigga.nextInt();

        if (nummin > nummaxx) {
            int pose = nummin;
            nummin = nummaxx;
            nummaxx = pose;

            double poro = Math.random() * (nummaxx - nummin) + nummin;
            int decir = (int)poro;
            System.out.println(decir);
        } else {

            double poro = Math.random() * (nummaxx - nummin) + nummin;
            int decir = (int)poro;
            System.out.println(decir);
        }






        //Ejercicio 4




        System.out.print("Dame un numero: ");
        Double numr = nigga.nextDouble();

        System.out.println("El resultado es " + Math.sqrt(numr));

    //Ejercicio 3

        System.out.println("Introduce un numero ascii entre 65-90, 97-122");
        int num = nigga.nextInt();

        char letra = (char) num;



         if (num >= 65 && num <= 90 || num >= 97 && num <=122)  {


             if (num == 65 || num == 69 || num == 73 || num == 79 || num == 85 || num == 97 || num == 101 || num == 105 || num == 111 || num == 117) {
                 System.out.println(letra);
                 System.out.println("Es vocal");

             } else {
                 System.out.println(letra);
                 System.out.println("No es vocal");
             }

         }  else {
             System.out.println("El indicado no es una letra");
         }



    // Ejercicio 2

        System.out.println("Dime tu nombre");
        String nombre = nigga.next();

        System.out.println("Hola, " + nombre);



    // Ejercicio 1

        System.out.println("Dame la base y l altura del rectangulo: ");
        double base = nigga.nextDouble();
        double altura = nigga.nextDouble();
        System.out.println("El area es de " + base*altura);
    }
}