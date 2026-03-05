package Ejercicio8;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Bookstore {

    private List<Book> bookList;
    private List<Author> authorList;

    public Bookstore() {
    }

    public Bookstore(List<Book> bookList, List<Author> authorList) {
        this.bookList = bookList;
        this.authorList = authorList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "bookList=" + bookList +
                ", authorList=" + authorList +
                '}';
    }
}
