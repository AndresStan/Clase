import java.util.Scanner;

public class ejercicio20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String frase;
        System.out.println("Dime la frase");
<<<<<<< HEAD
        String frase = sc.next();
        sc.nextLine();


=======
        frase = sc.nextLine();
>>>>>>> 54397ab9fe060550a54a3a76165eeffa1b048860

        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if ( frase.charAt(i) == 's' || frase.charAt(i) == 'S' ) {
                System.out.println(" Hay una s en la posicion " + (i+1));
                contador++;
            }


        }
        System.out.println( "En total hay " + contador + " s/S");

    }
}
