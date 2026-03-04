package Ejercicio3;

public class app {
    public static void main(String[] args) {

        MetodoPago pago1 = new TarjetaCredito();
        MetodoPago pago2 = new PayPal();
        MetodoPago pago3 = new TransferenciaBancaria();

        pago1.procesarPago(3.3);
        pago2.procesarPago(23.3);
        pago3.procesarPago(50.5);

    }
}
