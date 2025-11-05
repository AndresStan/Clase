import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {

        double numeroDouble = Math.random() * 100;
        int numeroAleatorio = (int) numeroDouble;
        Scanner sc = new Scanner(System.in);
        boolean adivinado = false;
        int contador = 0;
        boolean respuestaCorrecta = false;

        while (adivinado == false) {

            respuestaCorrecta = false;

            System.out.println("Indica un numero");


            while (!sc.hasNextInt()) {
                System.out.println("Indica algo valido");
                sc.nextLine();

            }


            int numeroEscrito = sc.nextInt();
            sc.nextLine();

            while (numeroEscrito < 0) {
                System.out.println("Porfavor, indica un caracter positivo");

                while (!sc.hasNextInt()) {
                    System.out.println("Indica algo valido");
                    sc.nextLine();

                }


            }

            contador = contador + 1;

            if (numeroEscrito == numeroAleatorio) {

                if (contador <= 5) {
                    System.out.println("Increible");


                }

                if (contador > 5 && contador <= 10) {
                    System.out.println("¡Muy bien!");
                }

                if (contador > 10) {
                    System.out.println("¡Sigue practicando!");
                }




                System.out.println("Te ha costado " + contador + " intentos");
                contador = 0;

                while (!respuestaCorrecta){

                    System.out.println("Quiere seguir jugando? (s/n)");
                    String respuesta = sc.next();
                    sc.nextLine();


                        if (respuesta.equalsIgnoreCase("s")) {
                            numeroDouble = Math.random() * 100;
                            numeroAleatorio = (int) numeroDouble;
                            adivinado = false;
                            respuestaCorrecta = true;
                        } else if (respuesta.equalsIgnoreCase("n")) {
                            adivinado = true;
                            respuestaCorrecta = true;
                            System.out.println("Hasta luego!");
                        } else {
                            System.out.println("Indique algo valido porfavor");
                        }



                }
            } else {

                if (numeroAleatorio > numeroEscrito) {
                    System.out.println("El numero ha adivinar es mayor que el numero que acabas de indicar");

                }

                if (numeroAleatorio < numeroEscrito) {
                    System.out.println("El numero ha adivinar es menor que el numero que acabas de indicar");

                }

            }




        }





    }
}

