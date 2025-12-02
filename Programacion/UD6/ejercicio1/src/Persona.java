import java.time.LocalDate;
import java.time.Period;

public class Persona {
    String nombre;
    String apellidos;
    LocalDate fechaDeNacimiento;
    String dni;
    char sexo;

    public Persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Persona(String nombre, String apellidos, LocalDate fechaDeNacimiento, String dni, char sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String saludar(){
        return "hola soy " + nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +" apellidos: " + apellidos +
                " fechaDeNacimiento: " + fechaDeNacimiento +
                " dni: " + dni +" sexo: " + sexo;
    }

    public int calcularEdad(){
        return Period.between(fechaDeNacimiento,LocalDate.now()).getYears();
    }
}
