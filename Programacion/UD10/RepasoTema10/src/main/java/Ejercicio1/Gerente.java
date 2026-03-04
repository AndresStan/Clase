package Ejercicio1;

public class Gerente extends Empleado{

    private double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    public Gerente() {
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " Bono: " + this.bono;
    }
}
