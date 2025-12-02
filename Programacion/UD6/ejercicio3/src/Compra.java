import java.util.ArrayList;

public class Compra {

    static void main(String[] args) {



        ArrayList<Linea> compra = new ArrayList<>();

        Linea articulo1 = new Linea("Jabon", 2 , 1.50, 1.21);
        Linea articulo2 = new Linea("Patatas", 10 , 1.75, 1.10);
        Linea articulo3 = new Linea("Leche", 1 , 3.50, 1.10);
        Linea articulo4 = new Linea("Galletas", 5 , 2.50, 1.21);
        Linea articulo5 = new Linea("Tomates", 20 , 0.50, 1.10);
        Linea articulo6 = new Linea("Huevos", 20 , 3.70, 1.10);



        compra.add(articulo6);
        articulo6.setUnidades(1);


        compra.add(articulo2);
        articulo2.setUnidades(5);

        compra.add(articulo1);
        articulo1.setUnidades(2);


        articulo1.setPrecio(0.40);


        double totalSinIva = 0;
        double totalConIva = 0;
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Linea i : compra){
            System.out.println(i.toString());
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            totalSinIva = totalSinIva + i.calcularValorLineaSinIva();
            totalConIva = totalConIva + i.calcularValorLineaConIva();
        }

        System.out.printf(" El total de la compra es sin iva es: " +  String.format("%.2f",totalSinIva) + "€");
        System.out.print(" -----------------");
        System.out.printf(" El total de la compra es con iva es: " +  String.format("%.2f",totalConIva) + "€");

    }


}
