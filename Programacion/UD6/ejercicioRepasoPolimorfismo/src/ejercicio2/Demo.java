package ejercicio2;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ArrayList Empleados = new ArrayList<Empleado>();

        Empleado e1 = new EmpleadoFijo("sd", 23.0);
        Empleado e2 = new EmpleadoFijo("sd", 23.0);
        Empleado e3 = new EmpleadoPorHoras("sd", 23.0, 6, 9);

        Empleados.add(e1);
        Empleados.add(e2);
        Empleados.add(e3);

    }
}
