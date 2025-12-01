import java.time.LocalDate;
import java.time.Period;

public class Empleado {
    String nombre;
    String apellidos;
    LocalDate fechaContratacion;
    String dni;
    double salario;
    String puesto;

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

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
    }

    public Empleado(String nombre, String apellidos, LocalDate fechaContratacion, String dni, double salario, String puesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
        this.dni = dni;
        this.salario = salario;
        this.puesto = puesto;
    }

    String trabajar(){
        return "Estoy trabajando como " + puesto;

    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + " fechaContratacion: " + fechaContratacion +
                " dni: " + dni + " salario: " + salario +
                " puesto: " + puesto;
    }

    Integer antiguedad(){
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }
}
