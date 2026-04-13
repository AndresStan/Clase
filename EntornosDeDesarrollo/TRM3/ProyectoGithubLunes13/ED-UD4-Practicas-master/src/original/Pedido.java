package original;

public class Pedido {
    public void procesarPedido(String tipoCliente, double totalCompra) {
        if (tipoCliente.equals("NORMAL")) {
            if (totalCompra > 100) {
                System.out.println("Descuento 5%");
                System.out.println("Total: " + (totalCompra - totalCompra * 0.05));
            } else {
                System.out.println("Sin descuento");
                System.out.println("Total: " + totalCompra);
            }
        } else if (tipoCliente.equals("VIP")) {
            if (totalCompra > 100) {
                System.out.println("Descuento 20%");
                System.out.println("Total: " + (totalCompra - totalCompra * 0.20));
            } else {
                System.out.println("Descuento 10%");
                System.out.println("Total: " + (totalCompra - totalCompra * 0.10));
            }
        } else {
            System.out.println("Tipo de cliente desconocido");
        }
    }
}
