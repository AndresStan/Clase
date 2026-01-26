package Ejercicio3;

public class TarjetaCredito extends MetodoPago{


    @Override
    public Double procesarPago(Double monto) {
        return monto + 5;
    }
}
