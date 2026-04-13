package Modelo;

public class Entrenador {
    private String id;
    private String nombreCompleto;
    private String codigoSala;

    public Entrenador() {
    }

    public Entrenador(String id, String nombreCompleto, String codigoSala) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.codigoSala = codigoSala;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }
}
