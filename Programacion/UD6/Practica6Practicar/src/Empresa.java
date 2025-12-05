import java.sql.SQLOutput;
import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> trabajadores;

    public ArrayList<Empleado> getTrabajadores() {
        return trabajadores;
    }

    public Empresa() {
        trabajadores = new ArrayList<>();
    }

    public Empresa(ArrayList<Empleado> trabajadores) {
        this.trabajadores = trabajadores;
    }

    void MostrarElementos(){
        if (trabajadores.isEmpty()) {
            System.out.println("No hay ningun elemento");
        } else {
            for (Empleado i : trabajadores){
                System.out.println(i);
            }
        }
    }

    double salarioPromedio(){
        if (trabajadores.isEmpty()) return 0.0;
        double salarioPromedio = 0.0;
        for (Empleado i : trabajadores){
            salarioPromedio = salarioPromedio + i.getSalario();

        }
        return salarioPromedio/trabajadores.size();
    }

    Empleado GetEmpleadoMayorAntiguedad(){
        if (trabajadores.isEmpty()) return null;
        Empleado masAntiguo = trabajadores.getFirst();
        for (Empleado i : trabajadores){
            if (i.antiguedad() > masAntiguo.antiguedad()){
                masAntiguo = i;
            }
        }
        return masAntiguo;
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
