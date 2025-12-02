public class ejercicio23 {
    static void main(String[] args) {

        String ruta = "/home/dam/Documents/UD05_Ejercicios.pdf";

        int posicionExtension = ruta.lastIndexOf('.');
        int posicionNombreArchivo = ruta.lastIndexOf('/');

        System.out.println("Extension: " + ruta.substring(posicionExtension+1,ruta.length()));
        System.out.println("Nombre del archivo: " + ruta.substring(posicionNombreArchivo+1, posicionExtension));
        System.out.println("Ruta del archivo: " + ruta.substring(0,posicionNombreArchivo));
    }
}
