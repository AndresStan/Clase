package Ejercicio3;

public class TransferenciaBancaria extends MetodoPago {


    @Override
    public Double procesarPago(Double monto) {
        return monto + 20;
    }
}
