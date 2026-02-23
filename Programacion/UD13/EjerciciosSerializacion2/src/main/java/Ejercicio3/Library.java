package Ejercicio3;

import java.util.ArrayList;

public class Library {


    ArrayList<Book> libreria = new ArrayList<>();


    public Library() {
    }



    public ArrayList<Book> getLibreria() {
        return libreria;
    }

    public void setLibro(Book libro) {
        libreria.add(libro);
    }
}


