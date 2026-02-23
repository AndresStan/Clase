package Ejercicio4;

import Ejercicio3.Book;

import java.util.ArrayList;

public class Library {


    ArrayList<Ejercicio3.Book> libreria = new ArrayList<>();


    public Library() {
    }



    public ArrayList<Ejercicio3.Book> getLibreria() {
        return libreria;
    }

    public void setLibro(Book libro) {
        libreria.add(libro);
    }


}


