package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sentencias extends Conexion {

    public static boolean validarUsuario(String dni, String password) {
        String sql = "SELECT dni FROM logged WHERE dni = ? AND contraseña = ?";

        try (Connection con = Conexion.crearConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, dni);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            // Si rs.next() es true, significa que encontró una coincidencia
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
