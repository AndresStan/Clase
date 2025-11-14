public class ejercicio31 {
    static void main(String[] args) {

        int contador = 0;
        int max = 0;
        int min = 0;
        int numeroRandom = 0;

        while (contador < 10) {

            numeroRandom = (int) (Math.random()*101);
            System.out.println(numeroRandom);
            contador++;

            if (contador == 1) {
                min = numeroRandom;
                max = numeroRandom;

            }
            if (numeroRandom < min) {
                min = numeroRandom;
            }

            if (numeroRandom > max) {
                max = numeroRandom;
            }

        }




        System.out.println("El valor maximo de la cadena es " + max + " \nEl valor minimo de la cadena es " + min);

    }
}
