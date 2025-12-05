import java.time.LocalDate;
import java.util.ArrayList;

public class DemoEmpresa {

    public static void main(String[] args) {


        Empleado empleado1 = new Empleado("Andres", "Stan", LocalDate.parse("2004-11-03"), "9999999D" , 1041.13, "Inspector");
        Empleado empleado2 = new Empleado("Paco", "Sanz", LocalDate.parse("2002-01-20"), "6454744F" , 1241.99, "Secretario");
        Empleado empleado3 = new Empleado("Carmen", "Villaroya", LocalDate.parse("2018-05-13"), "4432224D" , 804.12, "Atencion al cliente");

        ArrayList<Empleado> empleados = new ArrayList<>();

        Empresa Alcampo = new Empresa(empleados);

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        Alcampo.MostrarElementos();
        System.out.println(Alcampo.salarioPromedio());
        System.out.println(Alcampo.GetEmpleadoMayorAntiguedad());
        Alcampo.BuscarEmpleados("Atencion al cliente");


    }
}
