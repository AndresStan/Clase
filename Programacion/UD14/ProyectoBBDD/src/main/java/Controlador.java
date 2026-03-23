import javax.swing.plaf.PanelUI;
import java.sql.*;

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

    public static boolean EliminarUnAutor(String idAutor) throws SQLException {
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select ")
        }
    }




}
