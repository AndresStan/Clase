package refactorizado;

public class DescuentoVIP implements DescuentoStrategy {

    @Override
    public double aplicarDescuento(double totalCompra) {
        if (totalCompra > 100) {
            return totalCompra * 0.80;
        }
        return totalCompra * 0.90;
    }
}
