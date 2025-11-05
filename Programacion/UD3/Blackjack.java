import java.math.*;
import java.util.*;

public class Blackjack {

        public static int Carta() {
            return (int) (Math.random()*(10 - 1) + 1);

        }

        public static void empezarJuego(){
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(Carta());

            System.out.println("El croupier desvela su carta: " + Carta());


            System.out.println("Tus cartas: ");


        }


       public static void mostrarMenu() {

           Scanner sc = new Scanner(System.in);
           boolean opcionValida = false;



           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println(" ");
           System.out.println("-------------------------------------------------------");
           System.out.println("-------Bienvenido al menu de Stan's BlackJack!---------");
           System.out.println("-------------------------------------------------------");
           System.out.println("-----------------¿Que desea hacer?---------------------");
           System.out.println("-------------------------------------------------------");
           System.out.println("-----(1)--Jugar-Partida--------------------------------");
           System.out.println("-----(2)--Ver-Reglas-----------------------------------");
           System.out.println("-----(3)--Salir-del-BlackJack--------------------------");
           System.out.println("-------------------------------------------------------");



           while (!sc.hasNextInt()) {
               System.out.println("Porfavor indique una opcion valida");
               sc.nextLine();
           }

           int respuesta = sc.nextInt();


           while (!opcionValida) {

               if (respuesta == 1) {

                    opcionValida = true;
                   empezarJuego();

               }

               if (respuesta == 2) {
                   opcionValida = true;
                   MostrarReglas();
               }

               if (respuesta == 3) {
                   opcionValida = true;
                   SalirJuego();

               }


               if (respuesta != 1 && respuesta !=2 && respuesta !=3){
                   System.out.println("Porfavor, indica un caracter valido");
                   respuesta = sc.nextInt();
               }






           }


       }

        public static int DarCarta(){

            return (int) (Math.random()*(10 - 1) +1);

        }

        public static void SalirJuego() {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-----------------GRACIAS POR JUGAR---------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");

        }

        public static void MostrarReglas(){
           Scanner sc = new Scanner(System.in);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-------------------------------------------------------");
            System.out.println("---Se empieza repartiendo dos cartas a cada jugador----");
            System.out.println("----Si te pasas de 21 estas fuera, si no has llegado---");
            System.out.println("----puedes elegir pedir carta siempre que quieras------");
            System.out.println("----El croupier pide cartas hasta llegar a 18----------");
            System.out.println("--Puedes plantarte cuando quieras pero si el croupier--");
            System.out.println("---------saca mas que tu estas fuera de la vida--------");
            System.out.println("-------------------------------------------------------");
            System.out.println("---------------------Buena Suerte----------------------");
            System.out.println("---------Pulsa cualquier ENTER para continuar----------");
            System.out.println("-------------------------------------------------------");
            sc.nextLine();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            mostrarMenu();



        }


        public static void main(String[] args) {

                mostrarMenu();

        }


}
