package jjraprendizajevirtual.modelo.pojo;

public class Respuesta {
    private int idRespuesta;
    private String contenido;
    private String fechaCreacion;
    private int idPregunta;
    private int idUsuario;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, String contenido, String fechaCreacion, int idPregunta, int idUsuario) {
        this.idRespuesta = idRespuesta;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.idPregunta = idPregunta;
        this.idUsuario = idUsuario;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
