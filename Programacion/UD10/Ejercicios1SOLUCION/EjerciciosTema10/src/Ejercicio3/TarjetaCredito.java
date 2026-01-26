package Ejercicio3;

public class TarjetaCredito extends MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con tarjeta de crédito por $" + monto);
    }
}

