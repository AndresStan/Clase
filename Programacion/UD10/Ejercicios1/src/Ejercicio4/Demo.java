package Ejercicio4;

public class Demo {

    public static void main(String[] args) {


        CuentaBancaria ibercaja = new CuentaBancaria(123456789, "Andres Stan");

        ibercaja.depositar(250.0);

        System.out.println(ibercaja.mostrarSaldo());

        ibercaja.retirar(200.0);

        System.out.println(ibercaja.mostrarSaldo());

        System.out.println(ibercaja.getTitular());

        ibercaja.retirar(500.0);

        System.out.println(ibercaja.mostrarSaldo());



    }

}
