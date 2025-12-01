public class ejercicio16 {
    static void main(String[] args) {
        int numero = 9039;

        boolean esNegativo = numero < 0;
        int numPositivo = Math.abs(numero);
        int numeroInvertido = 0;

        while (numPositivo > 0){
            int digito = numPositivo % 10;
            numeroInvertido = numeroInvertido * 10 + digito;
            numPositivo = numPositivo / 10;

        }
        if (esNegativo) {
            System.out.println(-numeroInvertido);
        } else {
            System.out.println(numeroInvertido);
        }
    }
}