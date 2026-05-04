package Modelo;

import java.time.LocalDate;

public class Socio {

    private int id;
    private String dni;
    private String NombreCompleto;
    private String correoElectronico;
    private LocalDate fechaAlta;
    private String telefono;

    public Socio() {
    }

    public Socio(int id ,String dni, String nombreCompleto, String correoElectronico, LocalDate fechaAlta, String telefono) {
        this.id = id;
        this.dni = dni;
        NombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaAlta = fechaAlta;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
