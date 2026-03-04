package Ejercicio3;

public class PayPal extends MetodoPago{

    @Override
    public void procesarPago(Double monto) {
        System.out.println("Procesando pago de: " + monto + " con PayPal");
    }
}
