public class Pedido {
    public void procesarPedido(String tipoCliente, double totalCompra) {
        String descuento = "";
        if (tipoCliente.equals("NORMAL")) {
            if (totalCompra > 100) {
                descuento = "5%";
                totalCompra = totalCompra * 0.95; }
            else {descuento = "Sin descuento";}
         } else if (tipoCliente.equals("VIP")) {
            if (totalCompra > 100) {
                descuento = "20%";
                totalCompra = totalCompra * 0.80; }
            else {
                descuento = "10%";
                totalCompra = totalCompra * 0.90; }
            }
        // llamamos a la funcion que muestre todo:
        mostrarResultado(tipoCliente, totalCompra, descuento);
    }

    // Metodo mostrarResultado que saca por pantalla GÉNERICO
    public void mostrarResultado (String tipoCliente, double totalCompra, String descuento){
        if (tipoCliente.equalsIgnoreCase("NORMAL")|| tipoCliente.equalsIgnoreCase("VIP")) {
            System.out.println("Descuento " + descuento);
            System.out.println("Total: " + totalCompra);
        } else {
            System.out.println("Tipo de cliente desconocido");
        }
    }
}

// El primer error esta en tener mal formateado el doucmento, un documento claro ayuda
// a ver mejor el codigo a la vez que entenderlo mejor

// Luego tenemos un error de tener duplicado el mismo codigo cuando podemos tener uno solo que verifique
// los dos tipos de cliente que puede haber "normal y vip"

// Tambien podemos arreglar la aplicacion de descuentos al totalCompra, en lugar de restar el total multiplicado por 0.05 o la
// cantidad correspondiente (por ejemplo 0.05) podemos directamente multiplicar la cantidad total por 0.95

// Finalmente podemos cambiar el codigo poniendo una variable general con metodo y que dependiendo de el tipo de persona sea una u otra
// para finalmente aparezca un unico systemout println y no uno para cada tipo de persona

