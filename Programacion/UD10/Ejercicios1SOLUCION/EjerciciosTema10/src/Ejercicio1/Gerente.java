package Ejercicio1;

public class Gerente extends Empleado {
    private double bono;

    // Constructor
    public Gerente(String nombre, double salario, double bono) {
        super(nombre, salario); // Llama al constructor de Empleado
        this.bono = bono;
    }

    // Sobrescritura del método mostrarInfo
    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Muestra nombre y salario
        System.out.println("Bono: $" + bono);
        System.out.println("Salario total: $" + (salario + bono));
    }
}
