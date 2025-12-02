import java.util.ArrayList;

public class Personas {
   private ArrayList<Persona> personas = new ArrayList<>();


    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public Personas() {
    }

    public Personas(ArrayList<Persona> personas) {
        this.personas = personas;
    }


    public void mostrarElementos(){
        for (Persona i : personas){
            System.out.println(i);
        }
    }

    public double EdadMedia(){
        int suma = 0;
        int contador = 0;
            for (Persona i : personas){
                suma = suma + i.calcularEdad();
                contador++;

            }
        return suma/contador;
    }

    public Persona getPersonaMasAnciana(){
        int edadMaxima = personas.getFirst().calcularEdad();
        Persona devolucion = new Persona();
        for (Persona i: personas){
            if (i.calcularEdad() > edadMaxima){
                edadMaxima = i.calcularEdad();
                devolucion = i;

            }
        }
        return devolucion;
    }


}
