package jjraprendizajevirtual.modelo.pojo;

public class Recurso {
    private int idRecurso;
    private String autor;
    private String fechaDeCreacion;
    private String titulo;
    private String Url;
    private int idCurso;
    private int idTipoRecurso;

    public Recurso() {
    }

    public Recurso(int idRecurso, String autor, String fechaDeCreacion, String titulo, String Url, int idCurso, int idTipoRecurso) {
        this.idRecurso = idRecurso;
        this.autor = autor;
        this.fechaDeCreacion = fechaDeCreacion;
        this.titulo = titulo;
        this.Url = Url;
        this.idCurso = idCurso;
        this.idTipoRecurso = idTipoRecurso;
    }

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
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
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
    
    
}
