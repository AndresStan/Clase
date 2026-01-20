package hecprooll;

public class Persona {

    String nombre;
    String apellidos;
    int edad;

    public Persona(String nombre, int edad, String apellidos) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    void mostrarDatos(){

        System.out.print("Nombre: " + this.nombre + " Apellidos: " + this.apellidos + " Edad: " + this.edad);

    }
}
