import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {


        // EJERCICIOS INSERTOS

        /*
        if (Controlador.InsertarAutor(new Autor(4, "Andres", "Espana"))){
            System.out.println("Introducido");
        }
        if (Controlador.InsertarAutor(new Autor(5, "Luis", "Polonia"))){
            System.out.println("Introducido");
        }
        */


        // EJERCICIOS CONSULTAS

        //Controlador.ConsultarAutores();
        //Controlador.ConsultarLibrosConSuAutor();



        // EJERCICIOS  ACTUALIZAR TABLA
       /*
        if (Controlador.AumentarPrecioLibros10()){
            System.out.println("Precio aumentado correctamente");
        } else {
            System.out.println("Error al aumentar el precio");
        }
        */
        /*if (Controlador.CambiarPaisAutor("Marruecos", "3")){
            System.out.println("Pais cambiado correctamente");
        } else {
            System.out.println("Error al cambiar el pais");
        }
         */

        // EJERCICIOS ELIMINAR DATOS

        //Controlador.EliminarUnAutor("Andres");
        /*
        if (Controlador.EliminarLibrosDeAutor("J.K. Rowling")){

            System.out.println("Libros eliminados");
        } else {
            System.out.println("Autor no encontrado, o no tiene ningun libro");
        }
         */


        //EJERCICIOS CONSULTAS AVANZADAS
        //Controlador.LibrosMayorQue20();
        //Controlador.NumeroTotalLibros();
        //Controlador.PrecioMedioLibros();


    }
}
