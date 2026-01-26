package Ejercicio5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {

        cambiarContrasena(contrasena);
        this.nombreUsuario = nombreUsuario;


    }

    public void verificarContrasena(String ingreso){
        if (ingreso.equalsIgnoreCase(this.contrasena)){
            System.out.println("Contraseña correcta");
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }

    public void cambiarContrasena(String nuevaContrasena){

        Pattern patron = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])\\S{8,}");
        Matcher matcher = patron.matcher(nuevaContrasena);

        if (matcher.matches()) {
            System.out.println("Contraseña actualizada correctamente");
        } else {
            throw new IllegalArgumentException("La contraseña no cumnple con los requisitos minimos");
        }
    }



}
