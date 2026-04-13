package Controlador;

import Modelo.user;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class GestionUsuariosC {

    public DefaultListModel<String> cargarUsuarios() {
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();
            boolean admin;
            DefaultListModel<String> lista = new DefaultListModel<>();
            ResultSet resultSet = statement.executeQuery("SELECT u.dni, u.contraseña, u.admin FROM logged u");
            ArrayList<Modelo.user> list = new ArrayList<>();
            while (resultSet.next()){
                if (Objects.equals(resultSet.getString("u.admin"), "1")){
                    admin = true;
                } else {
                    admin = false;
                }
                list.add(new user(resultSet.getString("u.dni"), resultSet.getString("u.contraseña"), admin));
            }

            for (Modelo.user u : list) {
                lista.addElement(u.toString());
            }

            return lista;

        } catch (SQLException e) {
            System.out.println("Error mostrando libros con sus autores");
            e.printStackTrace();
        }

        return new DefaultListModel<>();
    }

    public boolean eliminarUsuario(String dni){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from logged where dni = ?");
            preparedStatement.setString(1, dni);
            int librosEliminados = preparedStatement.executeUpdate();
            return librosEliminados>0;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }



    public boolean añadirUsuario(user u){
        try (Connection connection = Conexion.crearConexion()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from logged where dni = ?");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into logged (dni, contraseña, admin) values (?, ?, ?)");
            preparedStatement1.setString(1, u.getDni());
            preparedStatement.setString(1, u.getDni());
            preparedStatement.setString(2, u.getContraseña());
            preparedStatement.setBoolean(3, u.isAdmin());
            ResultSet r1 = preparedStatement1.executeQuery();
            if (r1.next()) {

                return false;
            }
            int res = preparedStatement.executeUpdate();
            return res>0;

        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }



}
