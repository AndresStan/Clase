package Ejercicio3;

public class TarjetaCredito extends MetodoPago{

    @Override
    public void procesarPago(Double monto) {
        System.out.println("Procesando pago de: " + monto + " con tarjeta");
    }
}
