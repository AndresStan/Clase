package ejercicio2;

public class EmpleadoPorHoras extends Empleado{

    int horasTrabajadas;
    double tarifaHora;


    public EmpleadoPorHoras(String nombre, Double salario, int horasTrabajadas, double tarifaHora) {
        super(nombre, salario);
    }
}
