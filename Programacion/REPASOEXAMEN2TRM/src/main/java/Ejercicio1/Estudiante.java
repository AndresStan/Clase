package Ejercicio1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Estudiante {

    private int id;
    private String nombre;
    private int edad;

    @JsonIgnore
    @XmlTransient
    private String contrasenia;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, int edad, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @JsonIgnore
    @XmlTransient
    public String getContrasenia() {
        return contrasenia;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nombre + " " + this.edad + " " + this.contrasenia;
    }
}
