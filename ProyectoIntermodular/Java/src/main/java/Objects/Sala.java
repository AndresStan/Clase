package Objects;

public class Sala {
    private String id;
    private String nombre;
    private int capacidad;
    private String entrenador;

    public Sala() {
    }

    public Sala(String id, String nombre, int capacidad, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.entrenador = entrenador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
}
