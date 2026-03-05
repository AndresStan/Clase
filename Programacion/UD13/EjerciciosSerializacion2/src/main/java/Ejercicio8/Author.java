package Ejercicio8;

import Ejercicio8.Book;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Author {
    private String name;
    private List<Book> booksWritten;

    public Author() {
    }

    public Author(String name, List<Book> booksWritten) {
        this.name = name;
        this.booksWritten = booksWritten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void getLibros(){
        for (Book b : booksWritten){
            System.out.println(b.getAuthor() + " " + b.getTitle() + " " + b.getYearPublished());
        }
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
