package Controlador;

import java.sql.*;

public class Verificacion {

    public static boolean verificarRangoAdmin(String dni) {
        try (Connection con = Conexion.crearConexion()) {
            PreparedStatement pst = con.prepareStatement("SELECT admin FROM logged WHERE dni = ?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("admin");
            }
        } catch (SQLException ex) {


        }

        return false;
    }
}
