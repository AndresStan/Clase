package Ejercicio3;

public class PayPal extends MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal por $" + monto);
    }
}
