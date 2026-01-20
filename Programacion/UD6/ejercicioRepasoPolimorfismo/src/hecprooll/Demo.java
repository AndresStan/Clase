package hecprooll;

import ejercicio2.Empleado;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Persona> plantilla = new ArrayList<>();

        Programador p1 = new Programador("Andres" , 18 , "Stan" , "Java");
        Programador p2 = new Programador("Andres" , 18 , "Stan" , "Java");
        Programador p3 = new Programador("Andres" , 18 , "Stan" , "Java");

        plantilla.add(p1);
        plantilla.add(p2);
        plantilla.add(p3);

        for (Persona p : plantilla){
            if (p instanceof Programador){

                p.mostrarDatos();

            }
        }


    }
}
