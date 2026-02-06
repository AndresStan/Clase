package Ejercicio1;

public class Registro {

    private int id;
    private String primerNombre;
    private String ultimoNombre;
    private Double latitud;
    private Double longitud;
    private String dominio;
    private String correo;
    private String pais;
    private String ip;
    private String ultimoLogin;


    public Registro(int id, String primerNombre, String ultimoNombre, Double latitud, Double longitud, String dominio, String correo, String pais, String ip, String ultimoLogin) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.ultimoNombre = ultimoNombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dominio = dominio;
        this.correo = correo;
        this.pais = pais;
        this.ip = ip;
        this.ultimoLogin = ultimoLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getUltimoNombre() {
        return ultimoNombre;
    }

    public void setUltimoNombre(String ultimoNombre) {
        this.ultimoNombre = ultimoNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
}
