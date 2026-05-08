package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sentencias {

    public static boolean eliminarEstudiante(int id){

        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estudiantes where id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static ArrayList<String> mostrarCursos(){

        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, nombre, duracion from cursos");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<String> todo = new ArrayList<>();
            while (resultSet.next()){
                todo.add("Id: " + resultSet.getString("id") + " Nombre: " + resultSet.getString("nombre") + " Duracion: " + resultSet.getString("duracion"));
            }

            return todo;



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public static ArrayList<String> mostrarEstudiantesConCurso(){

        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.id, a.nombre, a.edad, c.nombre from estudiantes a join cursos c on a.id_curso = c.id");
            ArrayList<String> todo = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                todo.add("Id: " + resultSet.getString("a.id") + " Nombre: " + resultSet.getString("a.nombre") + " Edad: " + resultSet.getString("a.edad") + " Curso: " + resultSet.getString("c.nombre"));
            }
            return todo;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
