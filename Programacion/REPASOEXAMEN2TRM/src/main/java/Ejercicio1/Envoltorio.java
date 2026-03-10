package Ejercicio1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Envoltorio {

    private List<Estudiante> lista;

    public Envoltorio() {
    }

    public Envoltorio(List<Estudiante> lista) {
        this.lista = lista;
    }

    public List<Estudiante> getLista() {
        return lista;
    }

    public void setLista(List<Estudiante> lista) {
        this.lista = lista;
    }
}
