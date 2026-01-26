package Ejercicio3;

public class TransferenciaBancaria extends MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando transferencia bancaria por $" + monto);
    }
}
