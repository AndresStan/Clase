import java.util.Scanner;

public class ejercicio12 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("El valor de Fibonacci en la posición " + n + " es: " + fibonacciRecursivo(n));
    }

    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }


}
