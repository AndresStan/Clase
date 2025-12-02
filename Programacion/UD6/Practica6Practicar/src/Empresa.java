import java.sql.SQLOutput;
import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> trabajadores = new ArrayList<>();

    public ArrayList<Empleado> getTrabajadores() {
        return trabajadores;
    }

    public Empresa() {
    }

    public Empresa(ArrayList<Empleado> trabajadores) {
        this.trabajadores = trabajadores;
    }

    void MostrarElementos(){

        for (Empleado i : trabajadores){
            System.out.println(i.toString());
        }
    }

    double salarioPromedio(){

        double salarioPromedio = 0.0;
        for (Empleado i : trabajadores){
            salarioPromedio = salarioPromedio + i.getSalario();

        }
        return salarioPromedio/trabajadores.size();
    }

    Empleado GetEmpleadoMayorAntiguedad(){
        Empleado devolucion = trabajadores.getFirst();
        for (Empleado i : trabajadores){
            if (i.antiguedad() > devolucion.antiguedad()){
                devolucion = i;
            }
        }
        return devolucion;
    }

    void BuscarEmpleados(String nombreOPuesto){

        for (Empleado i : trabajadores){

            if (nombreOPuesto.equalsIgnoreCase(i.getNombre())){
                System.out.println(i.toString());
            } else if (nombreOPuesto.equalsIgnoreCase(i.getPuesto())) {
                System.out.println(i.toString());
            }

        }

    }
}
