public class Libro {

    private int id;
    private String titulo;
    private int precio;
    private int id_autor;


    public Libro(int id, String titulo, int precio, int id_autor) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.id_autor = id_autor;
    }

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
}
