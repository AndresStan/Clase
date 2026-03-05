package Ejercicio9;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
public class Publisher {
    private String name;
    private String address;
    private List<Book> booklist;

    public Publisher() {
    }

    public Publisher(String name, String address, List<Book> booklist) {
        this.name = name;
        this.address = address;
        this.booklist = booklist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooklist() {
        return this.booklist;
    }

    public void getBooklistMIO() {
        for (Book b : booklist){
            System.out.println(b.toString());
        }
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
}
