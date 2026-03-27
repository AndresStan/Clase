import java.sql.*;
import java.util.ArrayList;

public class Controlador {

    public static boolean InsertarEstudiante(Estudiante estudiante){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO estudiantes () values (?,?,?,?)");
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getNombre());
            statement.setInt(3, estudiante.getEdad());
            statement.setInt(4, estudiante.getId_curso());

            int filas = statement.executeUpdate();
            return filas>0;

        } catch (SQLException e) {
            System.out.println("Error insertando estudiante");
            e.printStackTrace();
        }
        return false;
    }


    public static ArrayList<String> ConsultarEstudiantes(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select e.nombre as nombree, c.nombre as nombre from estudiantes e join cursos c on e.id_curso = c.id");
            ArrayList<String> estudiantes = new ArrayList<>();
            while (resultSet.next()){
                estudiantes.add(resultSet.getString("nombree") + " " + resultSet.getString("nombre"));
            }
            return estudiantes;

        } catch (SQLException e) {
            System.out.println("Error mostrando autores");
            e.printStackTrace();
        }
        return null;
    }



    public static boolean CambiarEdadEstudiante(int edad, int id){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update estudiantes set edad = ? where id = ?");
            preparedStatement.setInt(1, edad);
            preparedStatement.setInt(2, id);
            int filas = preparedStatement.executeUpdate();
            return filas>0;
        } catch (SQLException e) {
            System.out.println("No se ha detectado ningún estudiante con ese id");
        }
        return false;
    }


    public static boolean EliminarEstudiante(int id) throws SQLException {
        try (Connection connection = Conexion.crearConexion()) {
          PreparedStatement preparedStatement = connection.prepareStatement("delete from estudiantes where id = ?");
          preparedStatement.setInt(1, id);
          int filas = preparedStatement.executeUpdate();
          return filas>0;
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar correctamente el estudiante");
        }
        return false;
    }

}
