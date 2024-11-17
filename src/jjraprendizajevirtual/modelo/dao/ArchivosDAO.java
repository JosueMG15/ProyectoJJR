package jjraprendizajevirtual.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jjraprendizajevirtual.modelo.ConexionBD;
import jjraprendizajevirtual.modelo.pojo.Recurso;

public class ArchivosDAO {

    public static boolean guardarRecurso(String titulo, String autor, String url) {
        boolean resultado = false;
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            PreparedStatement prepararSentencia = null;
            try {
                String consulta = "INSERT INTO recurso (Titulo, Autor, Url, Fecha_De_Creacion) VALUES (?, ?, ?, NOW())";
                prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setString(1, titulo);
                prepararSentencia.setString(2, autor);
                prepararSentencia.setString(3, url);
                resultado = prepararSentencia.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error al guardar recurso: " + e.getMessage());
            } finally {
                try {
                    if (prepararSentencia != null) prepararSentencia.close();
                    conexionBD.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public static List<Recurso> obtenerRecursos() {
        List<Recurso> recursos = new ArrayList<>();
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            PreparedStatement prepararSentencia = null;
            ResultSet resultado = null;
            try {
                String consulta = "SELECT r.PK_ID_Recurso, r.Titulo, r.Autor, r.Fecha_De_Creacion, r.Url, "
                        + "tr.NombreTipo, d.Contenido, i.Resolucion, v.Duracion "
                        + "FROM recurso r "
                        + "LEFT JOIN tiporecurso tr ON r.FK_Recurso_TipoRecurso = tr.PK_ID_TipoRecurso "
                        + "LEFT JOIN documento d ON r.PK_ID_Recurso = d.FK_Texto_Recurso "
                        + "LEFT JOIN imagen i ON r.PK_ID_Recurso = i.FK_Imagen_Recurso "
                        + "LEFT JOIN video v ON r.PK_ID_Recurso = v.FK_Video_Recurso";
                prepararSentencia = conexionBD.prepareStatement(consulta);
                resultado = prepararSentencia.executeQuery();
                while (resultado.next()) {
                    Recurso recurso = new Recurso();
                    recurso.setIdRecurso(resultado.getInt("PK_ID_Recurso"));
                    recurso.setTitulo(resultado.getString("Titulo"));
                    recurso.setAutor(resultado.getString("Autor"));
                    recurso.setFechaDeCreacion(resultado.getString("Fecha_De_Creacion"));
                    recurso.setUrl(resultado.getString("Url"));
                    recurso.setTipo(resultado.getString("NombreTipo"));

                    // Manejar datos específicos por tipo
                    switch (recurso.getTipo()) {
                        case "Documento":
                            recurso.setContenido(resultado.getString("Contenido"));
                            break;
                        case "Imagen":
                            recurso.setResolucion(resultado.getString("Resolucion"));
                            break;
                        case "Video":
                            recurso.setDuracion(resultado.getString("Duracion"));
                            break;
                    }
                    recursos.add(recurso);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener recursos: " + e.getMessage());
            } finally {
                try {
                    if (resultado != null) resultado.close();
                    if (prepararSentencia != null) prepararSentencia.close();
                    conexionBD.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("Conexión a la base de datos fallida.");
        }
        return recursos;
    }

    public static boolean guardarDocumento(String titulo, String autor, String url, String contenido) {
        return guardarRecursoGeneral(titulo, autor, url, "Documento", contenido, null, null);
    }

    public static boolean guardarImagen(String titulo, String autor, String url, String resolucion) {
        return guardarRecursoGeneral(titulo, autor, url, "Imagen", null, resolucion, null);
    }

    public static boolean guardarVideo(String titulo, String autor, String url, String duracion) {
        return guardarRecursoGeneral(titulo, autor, url, "Video", null, null, duracion);
    }

    private static boolean guardarRecursoGeneral(String titulo, String autor, String url, String tipo, String contenido, String resolucion, String duracion) {
        boolean resultado = false;
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            PreparedStatement prepararSentencia = null;
            try {
                String consulta = "INSERT INTO recurso (Titulo, Autor, Url, Fecha_De_Creacion, Tipo, Contenido, Resolucion, Duracion) "
                        + "VALUES (?, ?, ?, NOW(), ?, ?, ?, ?)";
                prepararSentencia = conexionBD.prepareStatement(consulta);
                prepararSentencia.setString(1, titulo);
                prepararSentencia.setString(2, autor);
                prepararSentencia.setString(3, url);
                prepararSentencia.setString(4, tipo);
                prepararSentencia.setString(5, contenido);
                prepararSentencia.setString(6, resolucion);
                prepararSentencia.setString(7, duracion);
                resultado = prepararSentencia.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error al guardar recurso general: " + e.getMessage());
            } finally {
                try {
                    if (prepararSentencia != null) prepararSentencia.close();
                    conexionBD.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }
}
