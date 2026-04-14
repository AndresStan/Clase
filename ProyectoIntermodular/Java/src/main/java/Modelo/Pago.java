package Modelo;

import java.time.LocalDate;

public class Pago {
    private int id;
    private String dniSocio;
    private LocalDate fecha;
    private double importe;

    public Pago() {
    }

    public Pago(int id, String dniSocio, LocalDate fecha, double importe) {
        this.id = id;
        this.dniSocio = dniSocio;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDniSocio() {
        return dniSocio;
    }

    public void setDniSocio(String dniSocio) {
        this.dniSocio = dniSocio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
