package Ejercicio3;

public class Main {
    public static void main(String[] args) {

        MetodoPago pago1 = new TarjetaCredito();
        MetodoPago pago2 = new PayPal();
        MetodoPago pago3 = new TransferenciaBancaria();

        pago1.procesarPago(150.50);
        pago2.procesarPago(75.00);
        pago3.procesarPago(300.00);
    }
}

