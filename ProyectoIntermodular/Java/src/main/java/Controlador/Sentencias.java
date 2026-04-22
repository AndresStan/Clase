package Controlador;

import Modelo.*;
import Vista.Gestor;

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
                    } catch (SQLException t){
                        return false;
                    }
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



        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }






    public static int DevolverUltimoIDMas1(int pestaña){
        try (Connection connection = Conexion.crearConexion()) {

            switch (pestaña){
                case 0: {
                    try (Connection con = Conexion.crearConexion()) {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) as ud FROM entrenador");
                        while (resultSet.next()){
                            return resultSet.getInt("ud");
                        }
                    } catch (SQLException t){
                        System.out.println("Error devolver ultimo id");
                    }
                }



                case 1: {
                    try (Connection con = Conexion.crearConexion()) {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) as ud FROM sala");
                        while (resultSet.next()){
                            return resultSet.getInt("ud");
                        }
                    } catch (SQLException t){
                        System.out.println("Error devolver ultimo id");
                    }
                }

                case 3: {
                    try (Connection con = Conexion.crearConexion()) {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) as ud FROM pago");
                        while (resultSet.next()){
                            return resultSet.getInt("ud");
                        }
                    } catch (SQLException t){
                        System.out.println("Error devolver ultimo id");
                    }
                }


            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return pestaña;
    }




    public static int InsertarObjeto(ArrayList<String> lista, int pestaña ){
        try (Connection connection = Conexion.crearConexion()) {

            switch (pestaña){
                case 0: {
                   try (Connection con = Conexion.crearConexion()) {
                       if (!Regex.verificarNombreCompleto(lista.get(1))){
                           return -3;
                       }

                       PreparedStatement preparedStatement = connection.prepareStatement("insert into entrenador (id, nombre_completo, codigoSala) values (?, ?, ?)");
                       preparedStatement.setString(1, String.valueOf(DevolverUltimoIDMas1(pestaña)+1));
                       preparedStatement.setString(2, lista.get(1));
                       preparedStatement.setString(3, lista.get(2));
                       int res = preparedStatement.executeUpdate();
                       return 1;
                   } catch (SQLException e) {
                       int codigo = e.getErrorCode(); // Obtiene el código numérico del motor
                       if (codigo == 1062) {
                          return -1; // clave duplicada
                       } else if (codigo == 1451 || codigo == 1452) {
                           return  -2; // No existe sala con ese id
                       } else {
                           return -67; // error desconocido
                       }
                   }
                }

                case 1: {
                    try (Connection con = Conexion.crearConexion()) {
                        if (!Regex.verificarNombreCompleto(lista.get(1))){
                            return -3;
                        }


                        PreparedStatement preparedStatement = connection.prepareStatement("insert into sala (id, nombre, capacidad) values (?, ?, ?)");
                        preparedStatement.setString(1, String.valueOf(DevolverUltimoIDMas1(pestaña)+1));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setString(3, lista.get(2));
                        int res = preparedStatement.executeUpdate();
                        return 1;
                    } catch (SQLException e) {
                        int codigo = e.getErrorCode(); // Obtiene el código numérico del motor
                        if (codigo == 1062) {
                            return -1; // clave duplicada
                        } else {
                            return -67; // error desconocido
                        }
                    }
                }

                case 2: {
                    try (Connection con = Conexion.crearConexion()) {
                        if (!Regex.verificarNombreCompleto(lista.get(1))){
                            return -3;
                        }

                        if (!Regex.validarFormatoDNI(lista.get(0))){
                            return -4;
                        }


                        if (!Regex.validarCorreo(lista.get(2))){
                            return -5;
                        }

                        if (!Regex.validarFecha(lista.get(3))){
                            return -6;
                        }

                        if (!Regex.validarTelefono(lista.get(4))){
                            return -7;
                        }





                        PreparedStatement preparedStatement = connection.prepareStatement("insert into socio (dni, nombre_completo, correo_electronico, fecha_alta, telefono) values (?, ?, ?, ?, ?)");
                        preparedStatement.setString(1, lista.get(0));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setString(3, lista.get(2));
                        preparedStatement.setString(4, lista.get(3));
                        preparedStatement.setString(5, lista.get(4));
                        int res = preparedStatement.executeUpdate();
                        return 1;
                    } catch (SQLException e) {
                        int codigo = e.getErrorCode(); // Obtiene el código numérico del motor
                        if (codigo == 1062) {
                            return -1; // clave duplicada
                        } else {
                            return -67; // error desconocido
                        }
                    }
                }

                case 3: {
                    try (Connection con = Conexion.crearConexion()) {

                        if (!Regex.validarFormatoDNI(lista.get(1))){
                            return -4;
                        }
                        if (!Regex.validarFecha(lista.get(2))){
                            return -6;
                        }
                        if (!Regex.esImportePositivo(lista.get(3))){
                            return -88;
                        }



                        PreparedStatement preparedStatement = connection.prepareStatement("insert into pago (id, dni_socio, fecha, importe) values (?, ?, ?, ?)");
                        preparedStatement.setString(1, String.valueOf(DevolverUltimoIDMas1(pestaña)+1));
                        preparedStatement.setString(2, lista.get(1));
                        preparedStatement.setString(3, lista.get(2));
                        preparedStatement.setString(4, lista.get(3));
                        int res = preparedStatement.executeUpdate();
                        return 1;
                    } catch (SQLException e) {
                        int codigo = e.getErrorCode(); // Obtiene el código numérico del motor
                        if (codigo == 1062) {
                            return -1; // clave duplicada

                        } else if (codigo == 1451 || codigo == 1452) {
                            return  -2;
                        } else {
                            return -67; // error desconocido
                        }

                    }
                }

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -3;
    }



}
