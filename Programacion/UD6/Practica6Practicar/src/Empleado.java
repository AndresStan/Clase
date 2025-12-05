import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeContratacion;
    private String dni;
    private double salario;
    private String puesto;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeContratacion() {
        return fechaDeContratacion;
    }

    public void setFechaDeContratacion(LocalDate fechaDeContratacion) {
        this.fechaDeContratacion = fechaDeContratacion;
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

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, LocalDate fechaDeContratacion) {
        this.nombre = nombre;
        this.fechaDeContratacion = fechaDeContratacion;
    }

    public Empleado(String nombre, String apellido, LocalDate fechaDeContratacion, String dni, double salario, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeContratacion = fechaDeContratacion;
        this.dni = dni;
        this.salario = salario;
        this.puesto = puesto;
    }

    String trabajar(){
        return "Estoy trabajando como: " + puesto;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " apellido: " + apellido + " fechaDeContratacion: "
                + fechaDeContratacion +" dni: " + dni +" salario: " + salario +
                " puesto: " + puesto;
    }

    public Integer antiguedad(){
        if (fechaDeContratacion == null) {
            return 0;
        } else {
            return (int) ChronoUnit.DAYS.between(fechaDeContratacion, LocalDate.now());
        }
    }
}
