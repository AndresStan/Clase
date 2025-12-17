import java.time.LocalDate;
import java.util.ArrayList;

public class DemoLibreria {

    static void main(String[] args) {

        ArrayList<Libros> libreriaEscolar = new ArrayList<>();

        Libros l1 = new Libros("Mortadela", "Luis fonsi", 67 , LocalDate.parse("2020-02-14"));
        Libros l2 = new Libros("Las turbo aventuras del semen", "Angel espilez", 69 , LocalDate.parse("1900-05-21"));
        Libros l3 = new Libros("El Quijote", "Miguel De Cervantes", 33 , LocalDate.parse("2007-12-21") );


        libreriaEscolar.add(l1);
        libreriaEscolar.add(l2);
        libreriaEscolar.add(l3);

        Libreria libreriaMundial = new Libreria(libreriaEscolar);

        libreriaMundial.mostrarLibreria();

        System.out.println(libreriaMundial.buscarLibro("Miguel DE CERVANTES"));


    }
}
