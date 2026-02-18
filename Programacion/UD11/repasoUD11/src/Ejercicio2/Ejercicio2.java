package Ejercicio2;

public class Ejercicio2  {
    public static void main(String[] args) {

        // Crear un Lambda de operaciones
        operaciones sumar = Double::sum;
        operaciones restar = (a, b) -> a-b;
        operaciones multiplicacion = (a, b) -> a*b;
        operaciones division = (a, b) -> b==0? 0 : a/b;

        operacionesConTres sumar3 = (a, b, c) -> a+b+c;
        operacionesConTres restar3 = (a, b, c) -> a-b-c;
        operacionesConTres multiplicacion3 = (a, b, c) -> a*b*c;
        operacionesConTres division3 = (a, b,  c) -> b==0||c==0? 0 : (a/b)/c;


        System.out.println(afonso.sumar(4.0,4.5));

    }
}
