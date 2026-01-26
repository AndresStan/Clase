package Ejercicio5;

import java.util.regex.Pattern;

public class Usuario {
    // Atributos privados
    private String nombreUsuario;
    private String contrasena;

    // Constructor
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Método para verificar la contraseña
    public boolean verificarContrasena(String ingreso) {
        return contrasena.equals(ingreso);
    }

    // Método para cambiar la contraseña con validación
    public boolean cambiarContrasena(String nuevaContrasena) {
        // Expresión regular: al menos una mayúscula, al menos un dígito, mínimo 8 caracteres
        String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        if (Pattern.matches(regex, nuevaContrasena)) {
            contrasena = nuevaContrasena;
            System.out.println("Contraseña cambiada correctamente.");
            return true;
        } else {
            System.out.println("La nueva contraseña no cumple los requisitos. Debe tener al menos una mayúscula, un dígito y mínimo 8 caracteres.");
            return false;
        }
    }

    // Getter para nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Setter para nombre de usuario
    public void setNombreUsuario(String nuevoNombre) {
        nombreUsuario = nuevoNombre;
        System.out.println("Nombre de usuario actualizado a: " + nombreUsuario);
    }
}

