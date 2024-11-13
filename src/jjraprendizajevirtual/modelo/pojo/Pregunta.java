package jjraprendizajevirtual.modelo.pojo;

public class Pregunta {
    private int idPregunta;
    private String contenido;
    private String fechaCreacion;
    private String titulo;
    private int idUsuario;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String contenido, String fechaCreacion, String titulo, int idUsuario) {
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
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
