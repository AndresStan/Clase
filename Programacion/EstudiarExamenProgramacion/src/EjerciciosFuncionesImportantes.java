import java.util.Enumeration;

public class EjerciciosFuncionesImportantes {
    public static void main(String[] args) {


       int[] array = {1,2,3,4,5};
       cambiararray(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }








        System.out.println(sumarCifras(444));
        System.out.println(SucesionFibonacci(11));
        System.out.println(Factorial(5));
        CuentaAtras(9);
        System.out.println("");
        calcularFactoriall(5);
        escribirFibonacci(5);
        System.out.println("");
        System.out.println(CalcularMayor(-3,-3));
    }
    static void cambiararray(int[] array){
        int[] array2 = {1,3,6,5,7,8};
        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }

    static void escribirFibonacci(int num){
        int contador = 2;
        int numeroAtras = 1;
        int numeroAtrasAtras = 1;
        int numeroFibo = 0;

        System.out.print("1 1 ");
        while (contador != num) {

            numeroFibo = numeroAtras + numeroAtrasAtras;
            numeroAtrasAtras = numeroAtras;
            numeroAtras = numeroFibo;
            System.out.print(numeroFibo +" ");
            contador++;

        }



    }

    static int CalcularMayor(int num1, int num2){
        if (num1 > num2){
            return num1;
        } else {
            return num2;
        }


    }

    static void calcularFactoriall(int num){

        int suma = 1;
        while (num > 1){
            suma = suma * num;
            num--;
        }
        System.out.println(suma);
    }

    static void CuentaAtras(int num){

        if (num < 0) {

        } else {
            System.out.print(num + " ");
            CuentaAtras(num-1);
        }
    }


    static int Factorial(int num){
        if (num <= 1){
            return num;
        } else {
            return num * Factorial(num-1);
        }
    }

    static int SucesionFibonacci(int num){
        if (num <= 1){
            return num;
        } else {
            return (SucesionFibonacci(num-1))+(SucesionFibonacci(num-2));
        }

    }


    static int sumarCifras (int num){
        if (num <= 1){
            return num;
        } else {
            return (num%10) + sumarCifras(num/10);
        }


    }


}