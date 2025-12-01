import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {


    public ArrayList<Empleado> trabajadores = new ArrayList<>();

    public ArrayList getTrabajador(){
        return trabajadores;
    }

    public Empresa() {
    }

    public Empresa(ArrayList<Empleado> trabajadores) {
        this.trabajadores = trabajadores;
    }

    void mostrarEmpleados(){
        for (Empleado i : trabajadores){
            System.out.println(i.toString());
        }
    }

    double salarioPromedio(){
        Double acumulador = 0.0;
        Integer contador = 0;
        for (Empleado i : trabajadores){
            contador++;
            acumulador = acumulador + i.getSalario();
        }
        return acumulador / contador;
    }

    Empleado getEmpleadoConMayorAntiguedad(){
        Empleado masAntiguo = trabajadores.getFirst();
        for (Empleado e : trabajadores) {
            if (e.antiguedad() > masAntiguo.antiguedad()) {
                masAntiguo = e;
            }
        }
        return masAntiguo;
    }


    void buscarEmpleado(String nombreOPuesto){
        for (Empleado i : trabajadores) {

            if (i.getNombre().equalsIgnoreCase(nombreOPuesto)){
                System.out.println(i.toString());
            } else if (i.getPuesto().equalsIgnoreCase(nombreOPuesto)) {
                System.out.println(i.toString());
            }
        }



    }




}
