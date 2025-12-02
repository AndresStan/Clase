import java.time.LocalDate;
import java.util.ArrayList;

public class alumno extends Persona {

    private Integer curso;
    private char grupo;
    private String asignaturas;

    public alumno(String nombre, String apellidos, LocalDate fechaDeNacimiento, String dni, char sexo, Integer curso, char grupo, String asignaturas) {
        super(nombre, apellidos, fechaDeNacimiento, dni, sexo);
        this.curso = curso;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return super.toString() + " curso: " + curso + " grupo: " + grupo +
                " asignaturas: " + asignaturas;
    }
}
