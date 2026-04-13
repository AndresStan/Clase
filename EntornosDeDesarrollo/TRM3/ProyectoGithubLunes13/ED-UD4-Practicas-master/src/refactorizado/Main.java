package refactorizado;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoNormal = new Pedido(new DescuentoNormal());
        pedidoNormal.procesarPedido(150);

        Pedido pedidoVIP = new Pedido(new DescuentoVIP());
        pedidoVIP.procesarPedido(150);
    }
}
