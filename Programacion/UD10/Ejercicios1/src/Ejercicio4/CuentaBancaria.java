package Ejercicio4;

public class CuentaBancaria {

    private int numeroCuenta;
    private String titular;
    private  Double saldo;


    public CuentaBancaria(int numeroCuenta, String titular, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public CuentaBancaria(int numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(Double monto){
        if (monto <= 0) {
            System.out.println("Error, deposito erroneo!");
        } else {
            this.saldo += monto;
        }
    }

    public void retirar(Double monto){

        if (this.saldo < monto) {
            System.out.println("No dispones de saldo suficiente para realizar la operación");
        } else {
            this.saldo -= monto;
        }
    }

    public Double mostrarSaldo(){
        return this.saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
