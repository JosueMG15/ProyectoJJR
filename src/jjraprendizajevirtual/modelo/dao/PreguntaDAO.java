package jjraprendizajevirtual.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import jjraprendizajevirtual.modelo.ConexionBD;
import jjraprendizajevirtual.modelo.pojo.Pregunta;
import jjraprendizajevirtual.modelo.pojo.Respuesta;

public class PreguntaDAO {

    public static boolean subirPregunta(Pregunta pregunta) {
        boolean resultado = false;
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                java.sql.Date fechaSQL = new java.sql.Date(pregunta.getFechaCreacion().getTime());
                String consulta = "INSERT INTO pregunta (Titulo, Contenido, FechaCreacion, FK_Pregunta_Usuario) "
                        + "VALUES (?,?,?,?)";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setString(1, pregunta.getTitulo());
                prepararSentencia.setString(2, pregunta.getContenido());
                prepararSentencia.setDate(3, fechaSQL);
                prepararSentencia.setInt(4, pregunta.getIdUsuario());
                int filasAfectadas = prepararSentencia.executeUpdate();
                if (filasAfectadas > 0) {
                    resultado = true;
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT PK_ID_Pregunta, Titulo, Contenido, FechaCreacion, "
                        + "FK_Pregunta_Usuario FROM Pregunta";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                while (resultado.next()) {
                    Pregunta pregunta = new Pregunta();
                    pregunta.setIdPregunta(resultado.getInt("PK_ID_Pregunta"));
                    pregunta.setTitulo(resultado.getString("Titulo"));
                    pregunta.setContenido(resultado.getString("Contenido"));
                    pregunta.setFechaCreacion(resultado.getDate("FechaCreacion"));
                    pregunta.setIdUsuario(resultado.getInt("FK_Pregunta_Usuario"));
                    preguntas.add(pregunta);
                }

                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return preguntas;
    }

    public static boolean agregarRespuesta(int idPregunta, String contenido, int idUsuario) {
        boolean resultado = false;
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "INSERT INTO respuesta (Contenido, FechaCreacion, FK_Respuesta_Pregunta, FK_Respuesta_Usuario) "
                        + "VALUES (?, NOW(), ?, ?)";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setString(1, contenido);
                prepararSentencia.setInt(2, idPregunta);
                prepararSentencia.setInt(3, idUsuario);
                int filasAfectadas = prepararSentencia.executeUpdate();
                if (filasAfectadas > 0) {
                    resultado = true;
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static List<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) {
        List<Respuesta> respuestas = new ArrayList<>();
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT r.Contenido, r.FechaCreacion, r.FK_Respuesta_Usuario, u.Nombre "
                        + "FROM respuesta r "
                        + "INNER JOIN usuario u ON r.FK_Respuesta_Usuario = u.PK_ID_Usuario "
                        + "WHERE r.FK_Respuesta_Pregunta = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setInt(1, idPregunta);
                ResultSet resultado = prepararSentencia.executeQuery();
                while (resultado.next()) {
                    Respuesta respuesta = new Respuesta();
                    respuesta.setContenido(resultado.getString("Contenido"));
                    respuesta.setFechaCreacion(resultado.getString("FechaCreacion"));
                    respuesta.setIdUsuario(resultado.getInt("FK_Respuesta_Usuario"));
                    respuesta.setNombreUsuario(resultado.getString("Nombre")); // Agrega el nombre del usuario
                    respuestas.add(respuesta);
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuestas;
    }

    public static String obtenerNombreUsuario(int idUsuario) {
        String nombre = "";
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT Nombre FROM usuario WHERE PK_ID_Usuario = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setInt(1, idUsuario);
                ResultSet resultado = prepararSentencia.executeQuery();
                if (resultado.next()) {
                    nombre = resultado.getString("Nombre");
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombre;
    }

}
