package Ejercicio1;

import java.time.LocalDateTime;

public class Registro {

    private int id;
    private String first_name;
    private String last_name;
    private double latitud;
    private double longitud;
    private String dominio;
    private String email;
    private String country;
    private String ip_address;
    private LocalDateTime last_login;

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", dominio='" + dominio + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", last_login=" + last_login +
                '}';
    }

    public Registro() {
    }

    public Registro(int id, String first_name, String last_name, double latitud, double longitud, String dominio, String email, String country, String ip_address, LocalDateTime last_login) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dominio = dominio;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
        this.last_login = last_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
