package jjraprendizajevirtual.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jjraprendizajevirtual.modelo.ConexionBD;
import jjraprendizajevirtual.modelo.pojo.Usuario;

public class AutenticacionDAO {
    
    public static Usuario iniciarSesionUsuario(String correoElectronico, String contrasena) {
        Usuario usuario = null;
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT PK_ID_Usuario, Nombre, Apellidos, Telefono, "
                        + "Correo_electronico, Contrasena, EsAdministrador "
                        + "FROM usuario WHERE Correo_electronico = ? AND Contrasena = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setString(1, correoElectronico);
                prepararSentencia.setString(2, contrasena);
                
                ResultSet resultadoSentencia = prepararSentencia.executeQuery();
                if (resultadoSentencia.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(resultadoSentencia.getInt("PK_ID_Usuario"));
                    usuario.setNombre(resultadoSentencia.getString("Nombre"));
                    usuario.setApellidos(resultadoSentencia.getString("Apellidos"));
                    usuario.setTelefono(resultadoSentencia.getString("Telefono"));
                    usuario.setCorreoElectronico(resultadoSentencia.getString("Correo_electronico"));
                    usuario.setContraseña(resultadoSentencia.getString("Contrasena"));
                    usuario.setAdministrador(resultadoSentencia.getInt("EsAdministrador") == 1 ? "1" : "0");
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
