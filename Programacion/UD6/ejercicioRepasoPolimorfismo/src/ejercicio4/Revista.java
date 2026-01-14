package ejercicio4;

public class Revista extends Publicacion{

    private int numeroEdicion;

    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " " + this.numeroEdicion;
    }
}
