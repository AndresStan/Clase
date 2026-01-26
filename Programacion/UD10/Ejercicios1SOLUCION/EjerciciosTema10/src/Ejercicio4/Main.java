package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan Pérez", 1000.0);

        // Mostrar saldo inicial
        cuenta.mostrarSaldo();

        // Depositar dinero
        cuenta.depositar(500);
        cuenta.mostrarSaldo();

        // Retirar dinero
        cuenta.retirar(200);
        cuenta.mostrarSaldo();

        // Intentar retirar más de lo disponible
        cuenta.retirar(2000);

        // Cambiar titular
        cuenta.setTitular("Ana Gómez");
        System.out.println("Titular actual: " + cuenta.getTitular());
    }
}
