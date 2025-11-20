import java.util.Scanner;

public class sara2 {
    static void main(String[] args) {

        Scanner martillo = new Scanner(System.in);
        int puntos = 0;
        System.out.println("Cual es tu color favorito");

        System.out.println("ROJO");
        System.out.println("AZUL");
        System.out.println("MORADO");
        System.out.println("ROSA PASTEL");

        String resultado = martillo.next();
        martillo.nextLine();


        if (resultado.equalsIgnoreCase("ROJO")) {
            puntos = 10;
        } else if (resultado.equalsIgnoreCase("AZUL")) {
            puntos = 20;
        } else if (resultado.equalsIgnoreCase("MORADO")) {
            puntos = 30;
        } else if (resultado.equalsIgnoreCase("ROSITA")){
            puntos = 500;
        } else {
            System.out.println("Wow, tienes personalidad");
        }


        if (puntos == 10) {
            System.out.println("Congrats, heterobasico");
        } else if (puntos == 20) {
            System.out.println("Congrats, hetecurioso");
        } else if (puntos == 30) {
            System.out.println("Sussy bisexual");
        } else if (puntos == 500) {
            System.out.println("Bujarra 100%");
        }

    }
}
