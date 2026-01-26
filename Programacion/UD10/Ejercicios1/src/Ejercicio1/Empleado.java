package Ejercicio1;

public class Empleado {

    private String nombre;
    private Double salarioBase;

    public Empleado(String nombre, Double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String mostrarInfo (){
        return "Nombre: " + nombre + ", salario: " + salarioBase;
    }


}
