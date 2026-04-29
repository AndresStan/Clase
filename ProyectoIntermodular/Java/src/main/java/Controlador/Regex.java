package Controlador;

import Vista.GestionUsuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Regex {

    static GestionUsuariosC guC = new GestionUsuariosC();

    public static boolean validarTelefono(String telefono) {

        String regex = "^[67][0-9]{8}$";
        return telefono != null && telefono.matches(regex);
    }


    public static boolean esImportePositivo(String texto) {
        try {
            // Convertimos a double (acepta enteros y decimales)
            // Reemplazamos la coma por punto por si el usuario usa formato europeo
            double valor = Double.parseDouble(texto.replace(",", "."));

            return valor > 0;
        } catch (Exception e) {
            // Si no es un número (ej: "abc") o está vacío, devuelve false
            return false;
        }
    }


    public static boolean validarFecha(String fecha) {
        // 1. Validar el formato con tu regex
        String regex = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        if (fecha == null || !fecha.matches(regex)) {
            return false;
        }

        try {
            // 2. Intentar parsear la fecha (esto detecta errores como 2023-02-30)
            LocalDate fechaIngresada = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate hoy = LocalDate.now();

            // 3. Verificar que no sea posterior a hoy
            return !fechaIngresada.isAfter(hoy);

        } catch (DateTimeParseException e) {
            return false;
        }
    }


    public static boolean validarCorreo(String correo) {
        String regex = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$";
        return correo != null && correo.matches(regex);
    }

    public static boolean validarFormatoDNI(String dni) {
        String regex = "^[0-9]{8}[A-Za-z]$";
        return dni != null && dni.matches(regex);
    }

    public static boolean esEntero(String valor) {
        return valor != null && valor.matches("-?\\d+");
    }



    public static boolean verificarNombreCompleto(String nombre) {
        // La regex verifica:
        // 1. Que empiece por Mayúscula (incluye tildes y Ñ)
        // 2. Que siga por una o más minúsculas
        // 3. Que si hay espacios, la siguiente palabra repita el patrón
        String regex = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)(\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$";

        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        return nombre.matches(regex);
    }

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
