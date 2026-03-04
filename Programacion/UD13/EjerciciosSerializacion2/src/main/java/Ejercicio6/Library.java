package Ejercicio6;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Library {
    List<Book> libreria = new ArrayList<>();

    public Library() {
    }

    public Library(List<Book> libreria) {
        this.libreria = libreria;
    }

    public void setLibro(Book libro){
        this.libreria.add(libro);
    }

    public List<Book> getLibreria() {
        return libreria;
    }

    public void setLibreria(List<Book> libreria) {
        this.libreria = libreria;
    }

    public void getLibros(){
        for (Book b: this.libreria){
            System.out.println(b.getAuthor() + " " + b.getTitle() + " " + b.getYearPublished());
        }

    }


}
