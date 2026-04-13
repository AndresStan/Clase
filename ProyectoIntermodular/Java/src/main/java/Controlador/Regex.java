package Controlador;

import Vista.GestionUsuarios;

import java.util.regex.Pattern;

public class Regex {

    static GestionUsuariosC guC = new GestionUsuariosC();

    public static int verificarAñadirUsuario(String dni, String pass , boolean admin) {

        Pattern dniPattern = Pattern.compile("^\\d{8}[A-Za-z]$");
        Pattern passPattern = Pattern.compile("^.{1,30}$");

        boolean dniValido = dniPattern.matcher(dni).matches();
        boolean passValida = passPattern.matcher(pass).matches();

        if (dniValido && passValida) {
            if (!guC.añadirUsuario(new Modelo.user(dni, pass, admin))){
                return 9;
            } else {
                return 1;
            }
        } else if (!dniValido && passValida) {
            return 2;
        } else if (dniValido && !passValida) {
            return 3;
        } else {
            return 4;
        }
    }

}
