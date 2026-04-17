package Controlador;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador extends Sentencias {

    public boolean verificarUsuario(String dni, String pass){
        Pattern patron = Pattern.compile("[\\d]{8}\\w{1}");
        Matcher matcher = patron.matcher(dni);
        Sentencias sentencias = new Sentencias();
        if (matcher.matches()){
            if (Sentencias.validarUsuario(dni,pass)){
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna coincidencia");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en el formato de DNI");
        }
        return false;
    }



}
