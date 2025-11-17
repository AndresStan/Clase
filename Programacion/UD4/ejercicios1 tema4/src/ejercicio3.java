import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero entero");
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime el numero al que lo quieres elevar");
        int num2 = sc.nextInt();
        sc.nextLine();

        System.out.println(elevar(num1,num2));



    }
    static int elevar(int num1, int num2){
        int resultado = num1;
        for (int i = num1; i > 0; i--) {

            resultado = num1* resultado;


        }
            return resultado;

    }
}
