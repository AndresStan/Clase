package Modelo;

public class user {
    private String dni;
    private String contraseña;
    private boolean admin;

    public user() {
    }

    public user(String dni, String contraseña, boolean admin) {
        this.dni = dni;
        this.contraseña = contraseña;
        this.admin = admin;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return dni + ' ' + admin;
    }

    public String toStringComplete() {
        return dni + ' ' + contraseña +' ' + admin;
    }
}
