package Ejercicio1;

public class Gerente extends Empleado{

    protected Double bonoAdicional;


    public Gerente(String nombre, Double salarioBase, Double bonoAdicional) {
        super(nombre, salarioBase);
        this.bonoAdicional = bonoAdicional;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", bonoAdicional: " + bonoAdicional + " Salario total: " + (salarioBase+bonoAdicional);
    }
}
