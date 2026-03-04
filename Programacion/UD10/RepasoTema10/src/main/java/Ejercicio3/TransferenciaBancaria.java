package Ejercicio3;

public class TransferenciaBancaria extends MetodoPago{

    @Override
    public void procesarPago(Double monto) {
        System.out.println("Procesando pago de: " + monto + " con transferencia Bancaria");
    }

}
