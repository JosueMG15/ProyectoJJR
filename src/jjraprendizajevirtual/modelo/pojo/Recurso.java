package jjraprendizajevirtual.modelo.pojo;

public class Recurso {
    private int idRecurso;
    private String autor;
    private String fechaDeCreacion;
    private String titulo;
    private String url;
    private int idCurso;
    private int idTipoRecurso;

    // Atributos específicos
    private String contenido; // Para documentos
    private String resolucion; // Para imágenes
    private String duracion; // Para videos
    private String tipo; // Para identificar el tipo de recurso (Documento, Imagen, Video)

    public Recurso() {
    }

    public Recurso(int idRecurso, String autor, String fechaDeCreacion, String titulo, String url, int idCurso, int idTipoRecurso, String tipo) {
        this.idRecurso = idRecurso;
        this.autor = autor;
        this.fechaDeCreacion = fechaDeCreacion;
        this.titulo = titulo;
        this.url = url;
        this.idCurso = idCurso;
        this.idTipoRecurso = idTipoRecurso;
        this.tipo = tipo;
    }

    // Getters y setters
    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
