package Ejercicio3;

public class Paypal extends MetodoPago{
    @Override
    public Double procesarPago(Double monto) {
        return monto;
    }
}
