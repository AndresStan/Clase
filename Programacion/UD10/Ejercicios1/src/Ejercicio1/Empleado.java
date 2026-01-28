package Ejercicio1;

public class Empleado {

    protected String nombre;
    protected Double salarioBase;

    public Empleado(String nombre, Double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String mostrarInfo (){
        return "Nombre: " + nombre + ", salario: " + salarioBase +"€";
    }


}
