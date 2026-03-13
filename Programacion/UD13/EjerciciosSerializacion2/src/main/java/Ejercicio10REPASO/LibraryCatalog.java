package Ejercicio10REPASO;

import java.util.HashMap;

public class LibraryCatalog {

    private HashMap<Author, Book> libraryCatalog;

    public LibraryCatalog() {
    }

    public LibraryCatalog(HashMap<Author, Book> libraryCatalog) {
        this.libraryCatalog = libraryCatalog;
    }

    public HashMap<Author, Book> getLibraryCatalog() {
        return libraryCatalog;
    }

    public void setLibraryCatalog(HashMap<Author, Book> libraryCatalog) {
        this.libraryCatalog = libraryCatalog;
    }

    public void mostrarLibreria(){
        System.out.println(libraryCatalog.entrySet());
    }
}
