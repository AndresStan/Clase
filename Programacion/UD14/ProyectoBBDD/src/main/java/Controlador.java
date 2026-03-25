import javax.swing.plaf.PanelUI;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Controlador {

    public static boolean InsertarAutor(Autor autor){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO autores (id, nombre, pais) values (?,?,?)");
            statement.setInt(1, autor.getId());
            statement.setString(2, autor.getNombre());
            statement.setString(3, autor.getPais());


            int filas = statement.executeUpdate();
            return filas>0;

        } catch (SQLException e) {
            System.out.println("Error insertando autor");
            e.printStackTrace();
        }
        return false;
    }


    public static boolean ConsultarAutores(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from autores");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("Nombre") + " " + resultSet.getString("pais"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando autores");
            e.printStackTrace();
        }
        return false;
    }



    public static boolean ConsultarLibrosConSuAutor(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select a.*, l.* from autores a join libros l on a.id = l.id_autor");

            while (resultSet.next()){
                System.out.println(resultSet.getString("l.id") + " " + resultSet.getString("titulo") + " " + resultSet.getString("precio") + " " + resultSet.getString("a.id") + " " + resultSet.getString("nombre") + " " + resultSet.getString("pais"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando libros con sus autores");
            e.printStackTrace();
        }
        return false;
    }


    public static boolean AumentarPrecioLibros10(){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update libros set precio = precio*1.10");
            int filas = preparedStatement.executeUpdate();
            return filas>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean CambiarPaisAutor(String pais, String idAutor){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update autores set pais = '" + pais + "' where id = " + idAutor);
            int filas = preparedStatement.executeUpdate();
            return filas>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void EliminarUnAutor(String autor){
        try (Connection connection = Conexion.crearConexion()) {
            Scanner sc = new Scanner(System.in);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from libros where id_autor = (select id from autores where nombre = '" + autor + "')");
            int libros = 0;
            boolean haylibro = false;
            while (resultSet.next()){
                libros++;
                haylibro = true;
            }
            if (haylibro == false){
                PreparedStatement preparedStatement = connection.prepareStatement("Delete from autores where nombre = '"+ autor + "';");
                int respuesta = preparedStatement.executeUpdate();
                if (respuesta > 0){
                    System.out.println("Autor " + autor + " eliminado");
                } else {
                    System.out.println("Autor no encontrado");
                }
            } else {
                System.out.println("El autor " + autor + " tiene " + libros + " libros , desea eliminar los libros tambien o cancelar? (si/cancelar)" );
                String intro = sc.nextLine();
                while (!Objects.equals(intro, "si") && !Objects.equals(intro, "cancelar")) {
                    System.out.println("Error, introduce (si/cancelar)");
                    intro = sc.nextLine();
                }
                if (intro.equals("si")){
                    String sqlLibros = "DELETE FROM libros WHERE id_autor = (SELECT id FROM autores WHERE nombre = ?)";
                    String sqlAutores = "DELETE FROM autores WHERE nombre = ?";

                    PreparedStatement psLibros = connection.prepareStatement(sqlLibros);
                    PreparedStatement psAutores = connection.prepareStatement(sqlAutores);

                    psLibros.setString(1, autor);
                    psAutores.setString(1, autor);

                    int librosBorrados = psLibros.executeUpdate();
                    int AutorBorrados = psAutores.executeUpdate();

                    System.out.println("Se han eliminado " + librosBorrados + " libros y "+ AutorBorrados  +" autor ");
                } else {
                    System.out.println("Cancelado");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean EliminarLibrosDeAutor(String autor) throws SQLException {
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from libros where id_autor = (select id from autores where nombre = ?)");
            preparedStatement.setString(1, autor);
            int librosEliminados = preparedStatement.executeUpdate();
            return librosEliminados>0;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }


    public static void LibrosMayorQue20(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select titulo from libros where precio > 20");
            System.out.println("Libros con precio mayor que 20€:");
            while (resultSet.next()){
                System.out.println(resultSet.getString("titulo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void NumeroTotalLibros(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as a from libros");
            while (resultSet.next()){
                System.out.println(resultSet.getString("a"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void PrecioMedioLibros(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select avg(precio) as a from libros");
            System.out.println("Precio medio de todos los libros:");
            while (resultSet.next()){
                System.out.println(resultSet.getString("a"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
