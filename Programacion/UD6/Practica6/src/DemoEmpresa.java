import java.time.LocalDate;
import java.util.ArrayList;

public class DemoEmpresa {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Andres Alexandro", "Pescaru Stan" , LocalDate.parse("2021-12-21"), "3633443Y", 1200.80, "Atencion al cliente");
        Empleado e2 = new Empleado("Luis Gabriel", "Stan" , LocalDate.parse("2018-05-11"), "2934443Y", 1150.40, "Secretario");
        Empleado e3 = new Empleado("Antonio munoz", "Stan" , LocalDate.parse("2020-02-09"), "1133443O", 1000.10, "Inspector general");
        ArrayList<Empleado> array = new ArrayList<>();

        array.add(e1);
        array.add(e2);
        array.add(e3);

        Empresa jamones = new Empresa(array);

        jamones.mostrarEmpleados();
        System.out.println(jamones.salarioPromedio());
        System.out.println(jamones.getEmpleadoConMayorAntiguedad());

        jamones.buscarEmpleado("Antonio munoz");

    }
}
