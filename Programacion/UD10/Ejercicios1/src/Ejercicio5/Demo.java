package Ejercicio5;

public class Demo {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Andres" , "Andres2007");

       u1.verificarContrasena("Andres2007");
       u1.cambiarContrasena("ContraseñaSegura");
       u1.cambiarContrasena("ContraseñaSegura777");


    }

}
