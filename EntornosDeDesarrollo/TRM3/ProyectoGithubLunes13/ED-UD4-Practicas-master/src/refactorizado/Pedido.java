package refactorizado;

public class Pedido {

    private DescuentoStrategy descuentoStrategy;

    public Pedido(DescuentoStrategy descuentoStrategy) {
        this.descuentoStrategy = descuentoStrategy;
    }

    public void procesarPedido(double totalCompra) {
        double totalFinal = descuentoStrategy.aplicarDescuento(totalCompra);
        System.out.println("Total final: " + totalFinal);
    }
}
