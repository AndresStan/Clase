package refactorizado;

public class DescuentoNormal implements DescuentoStrategy {

    @Override
    public double aplicarDescuento(double totalCompra) {
        if (totalCompra > 100) {
            return totalCompra * 0.95;
        }
        return totalCompra;
    }
}