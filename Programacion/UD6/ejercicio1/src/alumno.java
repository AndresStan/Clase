import java.time.LocalDate;

public class alumno extends Persona {

    Integer curso;
    char grupo;
    String matriculaciones;


    public alumno(String nombre, String apellidos, LocalDate fechaDeNacimiento, String dni, char sexo, Integer curso, char grupo, String matriculaciones) {
        super(nombre, apellidos, fechaDeNacimiento, dni, sexo);
        this.curso = curso;
        this.grupo = grupo;
        this.matriculaciones = matriculaciones;
    }

    @Override
    public String toString() {
        return "alumno{" +
                "curso=" + curso +
                ", grupo=" + grupo +
                ", matriculaciones='" + matriculaciones + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
