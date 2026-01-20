package hecprooll;

public class Programador extends  Persona{

    String lenguaje;

    public Programador(String nombre, int edad, String apellidos, String lenguaje) {
        super(nombre, edad, apellidos);
        this.lenguaje = lenguaje;
    }

    @Override
    void mostrarDatos() {
        super.mostrarDatos();
        System.out.print(" Lenguaje: " + this.lenguaje);
        System.out.println();
    }
}
