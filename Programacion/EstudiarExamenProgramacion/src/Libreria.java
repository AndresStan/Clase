import java.util.ArrayList;

public class Libreria {

    ArrayList<Libros> Libreria = new ArrayList<>();


    public Libreria(ArrayList<Libros> libreria) {
        Libreria = libreria;
    }

    public ArrayList<Libros> getLibreria() {
        return this.Libreria;
    }

    void mostrarLibreria(){

        if (Libreria.isEmpty()) {
            System.out.println("No hay libros TODAVIA");
        } else {
            for (Libros i : Libreria){
                System.out.println(i);
            }
        }


    }

    Libros buscarLibroMasAntiguo(){

        Libros masAntiguo = Libreria.getFirst();

        if (Libreria.isEmpty()) return null;


        for (Libros i : Libreria){
            if (i.antiguedadLibro() > masAntiguo.antiguedadLibro()){
                masAntiguo = i;
            }
        }
        return masAntiguo;

    }

    Libros buscarLibro(String nombreOCodigo) {

        boolean found = false;

        Libros aux = new Libros();

        if (Libreria.isEmpty()) {
            System.out.println("NO HAY LIBROS JODER");
            return null;
        }

        for (Libros i : Libreria) {
            if (nombreOCodigo.equalsIgnoreCase(i.getNombre()) || nombreOCodigo.equalsIgnoreCase(i.getAutor())) {
                aux = i;
                found = true;

            }
        }

        if (found){
            System.out.print("ENCONTRADO: ");
            return aux;
        } else {
            System.out.println("NO ENCONTRADO");
            return null;
        }



    }




}
