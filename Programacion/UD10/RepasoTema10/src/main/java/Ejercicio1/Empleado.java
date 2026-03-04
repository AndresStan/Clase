package Ejercicio1;

public class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado() {
    }

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String mostrarInfo(){
        return "Nombre: " + this.nombre + " Salario: " + this.salarioBase;
    }
}

