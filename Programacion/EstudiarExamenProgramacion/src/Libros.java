import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Libros {
    private String nombre;
    private  String autor;
    private  Integer codigo;
    private LocalDate fechaPublicacion;
    private Integer id;

    private static Integer idAuto = 1;

    public Libros() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libros(String nombre, String autor, Integer codigo, LocalDate fechaPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.codigo = codigo;
        this.fechaPublicacion = fechaPublicacion;
        this.id = idAuto++;

    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " Autor: " + autor + " codigo: " + codigo + " fechaPublicacion: "
                + fechaPublicacion + " id: " + id;
    }

    Integer antiguedadLibro(){

        return (int) ChronoUnit.YEARS.between(fechaPublicacion,LocalDate.now());

    }


}
