package Ejercicio4;

// Clase CuentaBancaria
public class CuentaBancaria {
    // Atributos privados (encapsulados)
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito de $" + monto + " realizado correctamente.");
        } else {
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    // Método para retirar dinero
    public void retirar(double monto) {
        if (monto > 0) {
            if (saldo >= monto) {
                saldo -= monto;
                System.out.println("Retiro de $" + monto + " realizado correctamente.");
            } else {
                System.out.println("Saldo insuficiente para retirar $" + monto);
            }
        } else {
            System.out.println("El monto a retirar debe ser mayor que cero.");
        }
    }

    // Método para mostrar el saldo
    public void mostrarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    // Getter para titular
    public String getTitular() {
        return titular;
    }

    // Setter para titular
    public void setTitular(String nuevoTitular) {
        this.titular = nuevoTitular;
        System.out.println("Titular actualizado a: " + titular);
    }
}
