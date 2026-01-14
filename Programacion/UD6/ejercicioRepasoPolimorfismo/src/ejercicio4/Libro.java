package ejercicio4;

public class Libro extends Publicacion{

    private int numPaginas;

    public Libro(String titulo, String autor, int numPaginas) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String mostrarInformacion() {
       return super.mostrarInformacion() + " " + this.numPaginas;
    }
}
