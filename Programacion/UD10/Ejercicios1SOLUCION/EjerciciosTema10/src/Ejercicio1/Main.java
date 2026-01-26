package Ejercicio1;

public class Main {
    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Carlos", 1500);
        Gerente ger1 = new Gerente("Ana", 3000, 800);

        System.out.println("Información del empleado:");
        emp1.mostrarInfo();

        System.out.println("\nInformación del gerente:");
        ger1.mostrarInfo();
    }
}
