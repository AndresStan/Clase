package Ejercicio3;

public class Demo {
    public static void main(String[] args) {
        // Pagar con paypal es gratuito
        // Pagar con TarjetaCredito suma 5 euros
        // Pagar con transferencia bancaria suma 20 euros

        MetodoPago p1 = new Paypal();
        MetodoPago tar1 = new TarjetaCredito();
        MetodoPago trans1 = new TransferenciaBancaria();

        System.out.println(p1.procesarPago(10.0));
        System.out.println(tar1.procesarPago(20.0));
        System.out.println(trans1.procesarPago(30.0));




    }
}
