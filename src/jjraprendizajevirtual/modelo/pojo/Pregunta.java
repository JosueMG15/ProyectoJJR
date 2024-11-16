package jjraprendizajevirtual.modelo.pojo;

import java.util.Date;

public class Pregunta {
    private int idPregunta;
    private String contenido;
    private Date fechaCreacion;
    private String titulo;
    private int idUsuario;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String contenido, Date fechaCreacion, String titulo, int idUsuario) {
        this.idPregunta = idPregunta;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.idUsuario = idUsuario;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
