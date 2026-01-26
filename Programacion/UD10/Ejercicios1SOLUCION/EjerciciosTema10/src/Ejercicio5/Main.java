package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        // Crear un usuario
        Usuario user = new Usuario("juan123", "Passw0rd");

        // Verificar contraseña
        System.out.println("Verificación correcta: " + user.verificarContrasena("Passw0rd"));
        System.out.println("Verificación incorrecta: " + user.verificarContrasena("12345678"));

        // Intentar cambiar contraseña con una que no cumple requisitos
        user.cambiarContrasena("password"); // Falla

        // Cambiar contraseña con una válida
        user.cambiarContrasena("NuevaPass1"); // Éxito

        // Verificar la nueva contraseña
        System.out.println("Verificación nueva contraseña: " + user.verificarContrasena("NuevaPass1"));
    }
}
