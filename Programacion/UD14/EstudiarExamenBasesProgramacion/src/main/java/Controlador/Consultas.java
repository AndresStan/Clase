package Controlador;

import Modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {

    public static boolean eliminarEstudiante(int id){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estudiantes where id = ?");
            preparedStatement.setInt(1, id);
           return  preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean actualizarEdadEstudiante(int id, int edad){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE estudiantes SET edad = ? where id = ?");
            preparedStatement.setInt(1, edad);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> selectCursos() {
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cursos");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<String> cursos = new ArrayList<>();
            while (resultSet.next()){
                cursos.add(resultSet.getString("id") + " " + resultSet.getString("nombre") + " " + resultSet.getString("duracion"));
            }
            return cursos;
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error select cursos");
            throw new RuntimeException(e);

        }
    }

    public static boolean insertarEstudiante(Estudiante e){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into estudiantes (nombre, edad, id_curso) values (?, ?, ?)");
            preparedStatement.setString(1, e.getNombre());
            preparedStatement.setInt(2, e.getEdad());
            preparedStatement.setInt(3, e.getId_curso());

            return preparedStatement.executeUpdate() > 0;


        } catch (Exception a) {
            throw new RuntimeException(a);
        }


    }

    public static ArrayList<String>  mostrarEstudiantesMasNombreCurso(){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select e.id, e.nombre, e.edad, c.nombre from estudiantes e join cursos c on e.id_curso = c.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<String> estudiantesYCursos = new ArrayList<>();
            while (resultSet.next()){
                estudiantesYCursos.add( "Id: " + resultSet.getString("e.id") + ", Nombre: " + resultSet.getString("e.nombre") + ", Edad: " + resultSet.getString("e.edad") + ", Nombre del curso: " + resultSet.getString("c.nombre"));
            }
            return estudiantesYCursos;

        } catch (Exception e) {
            System.out.println("Error mostrando los estudiantes y sus cursos");
            throw new RuntimeException(e);
        }
    }

}
