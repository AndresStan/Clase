import java.text.Format;

public class Linea {
    private String nombreArticulo;
    private  int unidades;
    private double precio;
    private double iva = .21;

    public Linea(String nombreArticulo, int unidades, double precio, double iva) {
        this.nombreArticulo = nombreArticulo;
        this.unidades = unidades;
        this.precio = precio;
        this.iva = iva;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    double calcularValorLineaConIva(){
        return unidades* (precio * iva);
    }

    double calcularValorLineaSinIva(){
        return (unidades*precio);

    }

    @Override
    public String toString() {
        return  nombreArticulo + " cantidad: " + unidades + " precio: " + precio + "€" + " iva: " + iva + " Valor sin iva: " +String.format("%.2f", calcularValorLineaSinIva()) + "€" + " Valor con iva: " + String.format("%.2f", calcularValorLineaConIva()) +"€";
    }
}
