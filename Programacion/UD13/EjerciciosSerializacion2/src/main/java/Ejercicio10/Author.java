package Ejercicio10;

import Ejercicio10.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement
public class Author {
    private String name;
    private List<Book> booksWritten;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
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

    @XmlTransient
    @JsonIgnore
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

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
