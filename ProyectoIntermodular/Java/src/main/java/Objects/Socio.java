package Objects;

import java.time.LocalDate;

public class Socio {
    private String dni;
    private String correoElectronico;
    private String NombreCompleto;
    private LocalDate fechaAlta;
    private String telefono;

    public Socio() {
    }

    public Socio(String dni, String correoElectronico, String nombreCompleto, LocalDate fechaAlta, String telefono) {
        this.dni = dni;
        this.correoElectronico = correoElectronico;
        NombreCompleto = nombreCompleto;
        this.fechaAlta = fechaAlta;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
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
