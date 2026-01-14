package ejercicio4;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Publicacion> publicaciones = new ArrayList<>();

        Libro HarryPotter = new Libro("Harry Potter", "Ricardo Perez", 315);
        Revista heraldo = new Revista("El Heraldo", "Aragon", 12);

        publicaciones.add(HarryPotter);
        publicaciones.add(heraldo);

        System.out.println(heraldo.mostrarInformacion());
        System.out.println(HarryPotter.mostrarInformacion());

        System.out.println(HarryPotter.getAutor());

    }
}
