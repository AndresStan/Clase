package Ejercicio10;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement
public class LibraryCatalog {
    private HashMap<Author, Book> catalogo;

    public LibraryCatalog() {
    }

    public LibraryCatalog(HashMap<Author, Book> catalogo) {
        this.catalogo = catalogo;
    }

    public HashMap<Author, Book> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(HashMap<Author, Book> catalogo) {
        this.catalogo = catalogo;
    }

   public void mostrarCatalogo(){
       System.out.println(catalogo.entrySet());
   }
}
