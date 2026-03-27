public class Estudiante {

    private int id;
    private String nombre;
    private int edad;
    private int id_curso;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, int edad, int id_curso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.id_curso = id_curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
}
