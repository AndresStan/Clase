import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class DemoPersonas {
    static void main(String[] args) {

        Persona p1 = new Persona("Andres", "Stan", LocalDate.parse("2007-12-21"), "354355D", 'M');
        Persona p2 = new Persona("Maria", "Stan", LocalDate.parse("1974-01-04"), "415788M", 'F');
        Persona p3 = new Persona("Luis", "Fonsi", LocalDate.parse("2002-04-16"), "232355F", 'M');
        Persona p4 = new alumno("Hector", "Criado", LocalDate.parse("2009-04-16"), "1115511H", 'M', 3, 'C', "Matematicas, lengua, filosofia");


        ArrayList<Persona> amigos = new ArrayList<>();
        Personas hermanos = new Personas(amigos);


        amigos.add(p1);
        amigos.add(p2);
        amigos.add(p3);
        amigos.add(p4);

        p3.setNombre("Paco");

        System.out.println(" ");

        hermanos.mostrarElementos();
        System.out.println("La edad media es: " + hermanos.EdadMedia());
        System.out.println(" ");
        System.out.println(hermanos.getPersonaMasAnciana());



    }
}
