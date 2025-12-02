import java.util.ArrayList;

public class Demo {
    static void main(String[] args) {
        ArrayList<Poligono> formas = new ArrayList<>();

        formas.add(new Triangulo(10,5));
        formas.add(new Cuadrado(15));
        formas.add(new Rectangulo(10, 10));
        formas.add(new Circunferencia(0.5));

        double areaTotal = 0;
        for (Poligono i : formas) {
            areaTotal = areaTotal + i.calcularArea();
        }

        System.out.println("El area total de todas las formas es: " + areaTotal);

    }
}
