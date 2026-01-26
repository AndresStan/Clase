package Ejercicio1;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("Andres", 2000.0);
        Gerente g1 = new Gerente("Luis", 2200.0, 500.0 );

        ArrayList<Empleado> plantilla = new ArrayList<>();

        plantilla.add(e1);
        plantilla.add(g1);

        for (Empleado e : plantilla){
            System.out.println(e.mostrarInfo());
        }

    }
}
