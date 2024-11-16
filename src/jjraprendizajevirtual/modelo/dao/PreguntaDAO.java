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
}
