package Controlador;

import Modelo.*;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Sentencias extends Conexion {

    public static boolean validarUsuario(String dni, String password) {
        String sql = "SELECT dni FROM logged WHERE dni = ? AND contraseña = ?";

        try (Connection con = Conexion.crearConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, dni);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public DefaultListModel<Entrenador> mostrarEntrenadores(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();

            DefaultListModel<Entrenador> lista = new DefaultListModel<>();
            ResultSet resultSet = statement.executeQuery("SELECT u.id, u.nombre_completo, u.codigoSala FROM entrenador u ORDER BY id ASC");
            ArrayList<Entrenador> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new Entrenador(resultSet.getInt("u.id"), resultSet.getString("u.nombre_completo"), resultSet.getString("u.codigoSala")));
            }

            for (Modelo.Entrenador u : list) {
                lista.addElement(u);
            }


            return lista;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return new DefaultListModel<>();
    }


    public DefaultListModel<Socio> mostrarSocios(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();

            DefaultListModel<Socio> lista = new DefaultListModel<>();
            ResultSet resultSet = statement.executeQuery("SELECT u.dni, u.nombre_completo, u.correo_electronico, u.fecha_alta, u.telefono FROM socio u ORDER BY nombre_completo ASC");
            ArrayList<Socio> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new Socio(resultSet.getString("u.dni"), resultSet.getString("u.nombre_completo"), resultSet.getString("u.correo_electronico"), resultSet.getDate("u.fecha_alta").toLocalDate(), resultSet.getString("u.telefono")));
            }

            for (Modelo.Socio u : list) {
                lista.addElement(u);
            }

            return lista;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return new DefaultListModel<>();
    }

    public DefaultListModel<Pago> mostrarPagos(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();

            DefaultListModel<Pago> lista = new DefaultListModel<>();
            ResultSet resultSet = statement.executeQuery("SELECT u.id, u.dni_socio, u.fecha, u.importe FROM pago u ORDER BY u.id ASC");
            ArrayList<Pago> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new Pago(resultSet.getInt("u.id"), resultSet.getString("u.dni_socio"), resultSet.getDate("u.fecha").toLocalDate(), resultSet.getDouble("u.importe")));
            }

            for (Modelo.Pago u : list) {
                lista.addElement(u);
            }

            return lista;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return new DefaultListModel<>();
    }

    public DefaultListModel<Sala> mostrarSalas(){
        try (Connection connection = Conexion.crearConexion()) {
            Statement statement = connection.createStatement();

            DefaultListModel<Sala> lista = new DefaultListModel<>();
            ResultSet resultSet = statement.executeQuery("SELECT u.id, u.nombre, u.capacidad from sala u ORDER BY u.id ASC");
            ArrayList<Sala> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new Sala(resultSet.getInt("u.id"), resultSet.getString("u.nombre"), resultSet.getInt("u.capacidad")));
            }

            for (Modelo.Sala u : list) {
                lista.addElement(u);
            }

            return lista;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return new DefaultListModel<>();
    }

    public static boolean EliminarObjeto(ArrayList<String> lista, int pestaña ){
        try (Connection connection = Conexion.crearConexion()) {

            switch (pestaña){
                case 0: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("Delete from entrenador where id = ?");
                        preparedStatement.setString(1, lista.getFirst());
                        int r = preparedStatement.executeUpdate();
                        return r>0;
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    return false;
                }

                case 1: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("Delete from sala where id = ?");
                        preparedStatement.setString(1, lista.getFirst());
                        int r = preparedStatement.executeUpdate();
                        return r>0;
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    return false;
                }

                case 2: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("Delete from socio where DNI = ?");
                        preparedStatement.setString(1, lista.getFirst());
                        int r = preparedStatement.executeUpdate();
                        return r>0;
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    return false;
                }

                case 3: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("Delete from pago where id = ?");
                        preparedStatement.setString(1, lista.getFirst());
                        int r = preparedStatement.executeUpdate();
                        return r>0;
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    return false;
                }

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static boolean InsertarObjeto(ArrayList<String> lista, int pestaña ){
        try (Connection connection = Conexion.crearConexion()) {

            switch (pestaña){
                case 0: {
                   try (Connection con = Conexion.crearConexion()) {
                       PreparedStatement preparedStatement = connection.prepareStatement("insert into entrenador (id, nombre_completo, codigoSala) values (?, ?, ?)");
                       preparedStatement.setString(1, lista.get(0));
                       preparedStatement.setString(2, lista.get(1));
                       preparedStatement.setString(3, lista.get(2));
                       int res = preparedStatement.executeUpdate();
                       return res>0;
                   } catch (Exception e) {
                       throw new RuntimeException(e);
                   }
                }

                case 1: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into sala (id, nombre, capacidad) values (?, ?, ?)");
                        preparedStatement.setString(1, lista.get(0));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setString(3, lista.get(2));
                        int res = preparedStatement.executeUpdate();
                        return res>0;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                case 2: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into socio (dni, nombre_completo, correo_electronico, fecha_alta, telefono) values (?, ?, ?, ?, ?)");
                        preparedStatement.setString(1, lista.get(0));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setString(3, lista.get(2));
                        preparedStatement.setString(4, lista.get(3));
                        preparedStatement.setString(5, lista.get(4));
                        int res = preparedStatement.executeUpdate();
                        return res>0;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                case 3: {
                    try (Connection con = Conexion.crearConexion()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into pago (id, dni_socio, fecha, importe) values (?, ?, ?, ?)");
                        preparedStatement.setString(1, lista.get(0));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setDate(3, java.sql.Date.valueOf(lista.get(2)));
                        preparedStatement.setString(4, lista.get(3));
                        int res = preparedStatement.executeUpdate();
                        return res>0;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



}
